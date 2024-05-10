package model.dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioDAO implements Consulta{
    //TODO: Cambiar a aprametro String, y hacer static final con los strings


    @Override
    public String getQuery(String query) {
        return query;
    }

    public static void insertar(Usuario usuario) {
        try {
            Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                    Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
            System.out.println("Conectado");
            String insert = "insert into usuario (userName, firstName, surname, password) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setString(1, usuario.getUserName());
            pstmt.setString(2, usuario.getFirstName());
            pstmt.setString(3, usuario.getSurName());
            pstmt.setString(4, usuario.getPassword());
            // Ejecutar la consulta de inserción
            int filasAfectadas = pstmt.executeUpdate();
            comprobarInsercion(filasAfectadas);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean comprobarInsercion(int filasAfectadas){
        String[] textoComprobarInsercion = {"Inserción exitosa", "La inserción no tuvo éxito"};
        if (filasAfectadas > 0) {
            System.out.println(textoComprobarInsercion[0]);
            return true;
        } else {
            System.out.println(textoComprobarInsercion[1]);
            return false;
        }

    }

}
