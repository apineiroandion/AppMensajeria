package model.dao;

import model.Conversacion;
import model.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase UserDAO que maneja las operaciones de la base de datos relacionadas con los usuarios.
 * Esta clase proporciona métodos para obtener usuarios de la base de datos y para añadir nuevos usuarios a la base de datos.
 */
public class UserDAO {

    /**
     * Obtiene todos los usuarios de una conversación específica de la base de datos.
     * Este método consulta la tabla 'tienen' en la base de datos y devuelve una lista de objetos User.
     *
     * @param codigoConversacion el código de la conversación de la que se van a obtener los usuarios.
     * @return ArrayList<User> una lista de todos los usuarios en la conversación especificada en la base de datos.
     * @throws RuntimeException si ocurre un error al obtener los usuarios de la conversación de la base de datos.
     */
    public static ArrayList<User> getUserByConversationFromDB(Integer codigoConversacion) {
        ArrayList<User> usersByC = new ArrayList<>();
        String queryTienen = "SELECT userName FROM tienen WHERE codigoConversacion = ?";
        String queryUsuarios = "SELECT * FROM users WHERE userName = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmtTienen = con.prepareStatement(queryTienen)) {

            pstmtTienen.setInt(1, codigoConversacion);

            try (ResultSet rsTienen = pstmtTienen.executeQuery()) {
                while (rsTienen.next()) {
                    String userName = rsTienen.getString("username");

                    // Ahora obtenemos los detalles del usuario desde la tabla usuarios
                    try (PreparedStatement pstmtUsuarios = con.prepareStatement(queryUsuarios)) {
                        pstmtUsuarios.setString(1, userName);

                        try (ResultSet rsUsuarios = pstmtUsuarios.executeQuery()) {
                            if (rsUsuarios.next()) {
                                String firstName = rsUsuarios.getString("firstname");
                                String surName = rsUsuarios.getString("surname");
                                String password = rsUsuarios.getString("password");
                                User user = new User(userName, firstName, surName, password);
                                usersByC.add(user);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos", e);
        }

        return usersByC;
    }


    /**
     * Obtiene todos los usuarios de la base de datos.
     * Este método consulta la tabla de usuarios en la base de datos y devuelve una lista de objetos User.
     *
     * @return ArrayList<User> una lista de todos los usuarios en la base de datos.
     * @throws RuntimeException si ocurre un error al obtener los usuarios de la base de datos.
     */
    public static ArrayList<User> getUserFromDB(){
        ArrayList<User> users = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                String userName = rs.getString("username");
                String firstName = rs.getString("firstname");
                String surName = rs.getString("surname");
                String password = rs.getString("password");
                User user = new User(userName, firstName, surName, password);
                user.setConversaciones(ConversacionDAO.getConversacionesByUserFromDB(user));
                users.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos", e);
        }
        return users;
    }

    /**
     * Añade un nuevo usuario a la base de datos.
     * Este método inserta un nuevo usuario en la tabla de usuarios en la base de datos.
     *
     * @param user el objeto User que representa al usuario que se va a añadir a la base de datos.
     * @throws RuntimeException si ocurre un error al añadir el usuario a la base de datos.
     */
    public static boolean addUserToDB(User user){
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (userName, firstName, surName, password) VALUES (?, ?, ?, ?)")) {

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getSurName());
            pstmt.setString(4, user.getPassword());
            pstmt.executeUpdate();
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Error al añadir usuario a la base de datos", e);
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     * Este método elimina un usuario de la tabla de usuarios en la base de datos.
     *
     * @param userName el nombre de usuario del usuario que se va a eliminar de la base de datos.
     * @throws RuntimeException si ocurre un error al eliminar el usuario de la base de datos.
     */
    public static void deleteUserFromDB(String userName){
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM users WHERE userName = ?")) {

            pstmt.setString(1, userName);
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar usuario de la base de datos", e);
        }
    }

    /**
     * Actualiza un usuario en la base de datos.
     * Este método actualiza los detalles de un usuario existente en la tabla de usuarios en la base de datos.
     *
     * @param user el objeto User que representa al usuario cuyos detalles se van a actualizar en la base de datos.
     * @throws RuntimeException si ocurre un error al actualizar el usuario en la base de datos.
     */
    public static void updateUserFromDB(User user){
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("UPDATE users SET firstName = ?, surName = ?, password = ? WHERE userName = ?")) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getSurName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getUserName());
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar usuario en la base de datos", e);
        }
    }

    /**
     * Borra todos los usuarios de la base de datos
     */
    public static void deleteAllUsersFromDB(){
        try (Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM users")){
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al borrar usuarios");
        }
    }

    /**
     * Obtiene un usuario de la base de datos para el inicio de sesión.
     * Este método consulta la tabla de usuarios en la base de datos y devuelve un objeto User si el nombre de usuario y la contraseña coinciden.
     *
     * @param userName el nombre de usuario del usuario que se va a obtener de la base de datos.
     * @param password la contraseña del usuario que se va a obtener de la base de datos.
     * @return User el objeto User que representa al usuario obtenido de la base de datos.
     * @throws RuntimeException si ocurre un error al obtener el usuario de la base de datos.
     */
    public static User getUserForLogin(String userName, String password) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE userName = ? AND password = ?")) {

            pstmt.setString(1, userName);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dbUserName = rs.getString("username");
                    String firstName = rs.getString("firstname");
                    String surName = rs.getString("surname");
                    String dbPassword = rs.getString("password");

                    return new User(dbUserName, firstName, surName, dbPassword);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos", e);
        }
        return null;
    }

}
