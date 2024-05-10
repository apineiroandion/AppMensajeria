package model.dao;

import model.Usuario;

import java.sql.*;

/**
 * CRUD de Usuarios
 */
public class UsuarioDAO implements Consulta{
    /**
     * Metodod que aporta la quey que solicitas
     * @param query
     * @return string con la consulta
     */
    @Override
    public String getQuery(String query) {
        return query;
    }

    /**
     * Metodo que inserta un usuario en la base de datos
     * @param usuario
     */
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

    /**
     * Metodo que comprueba que la insecion se hizo correctamente
     * @param filasAfectadas
     * @return bolleano de comrpobacion
     */
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

    public static void consultar(String query) {
        try {
            Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                    Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
            System.out.println("Conectado");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Procesar los resultados de la consulta
            while (rs.next()) {
                // Accede a los datos de cada fila
                int id = rs.getInt("idu");
                String nombre = rs.getString("userName");
                // Hacer algo con los datos...
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + rs.getString("surname"));
            }
            // Cerrar ResultSet, Statement y conexión
            rs.close();
            stmt.close();
            con.close(); // Cierra la conexión
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Fin metodo");
    }

}
