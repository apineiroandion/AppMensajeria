package model.dto;

import model.Usuario;
import model.dao.Conexion;
import model.dao.Consulta;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDTO implements Consulta {
    @Override
    public String getQuery(String query) {
        return query;
    }
    public static ArrayList<Usuario> nuevoUsuario(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                    Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
            System.out.println("Conectado");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            // Procesar los resultados de la consulta
            while (rs.next()) {
                // Crear un objeto Usuario con los datos de la fila actual
                Integer id = rs.getInt("idu");
                String userName = rs.getString("userName");
                String firstName = rs.getString("firstName");
                String apellido = rs.getString("surName");
                String password = rs.getString("password");
                // Crear un objeto Usuario y agregarlo a la lista
                Usuario usuario = new Usuario(id, userName, firstName, apellido, password); // Suponiendo que tienes un constructor en la clase Usuario
                usuarios.add(usuario);
            }
            // Cerrar ResultSet, Statement y conexión
            rs.close();
            stmt.close();
            con.close(); // Cierra la conexión
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Fin metodo");
        return usuarios;
    }

}

