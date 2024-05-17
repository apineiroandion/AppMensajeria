package model.dao;

import model.Conversacion;
import model.User;

import java.sql.*;
import java.util.ArrayList;

import static model.UserModel.users;
/**
 * Clase ConversacionDAO que maneja las operaciones de la base de datos relacionadas con las conversaciones.
 * Esta clase proporciona métodos para obtener conversaciones de la base de datos.
 */
public class ConversacionDAO {
    /**
     * Obtiene todas las conversaciones de un usuario específico de la base de datos.
     * Este método consulta la tabla de conversaciones en la base de datos y devuelve una lista de objetos Conversacion.
     *
     * @param user el objeto User que representa al usuario cuyas conversaciones se van a obtener de la base de datos.
     * @return ArrayList<Conversacion> una lista de todas las conversaciones del usuario en la base de datos.
     * @throws RuntimeException si ocurre un error al obtener las conversaciones del usuario de la base de datos.
     */
    public static ArrayList<Conversacion> getConversacionesByUserFromDB(User user) {
        ArrayList<Conversacion> conversaciones = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tienen WHERE userName = ?")) {

            pstmt.setString(1, user.getUserName());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer codigoConversacion = rs.getInt("codigoConversacion");
                ArrayList<User> participantes = UserDAO.getUserByConversationFromDB(codigoConversacion);
                Conversacion conversacion = new Conversacion(codigoConversacion, participantes.getFirst(), participantes.getLast());
                conversaciones.add(conversacion);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener conversaciones del usuario de la base de datos", e);
        }
        return conversaciones;
    }

    /**
     * Comprueba la inserción de una nueva conversación en la base de datos
     * y luego imprime todas las conversaciones existentes.
     */
    public static void comprobarInsertConversacion() {
        insertarConversacion();
        imprimirConversaciones();
    }

    /**
     * Inserta una nueva conversación en la tabla `conversacion` de la base de datos.
     * La columna `codigoConversacion` es de tipo SERIAL y se genera automáticamente.
     *
     * @throws RuntimeException si ocurre un error durante la inserción en la base de datos.
     */
    private static void insertarConversacion() {
        String insertSQL = "INSERT INTO conversacion DEFAULT VALUES";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar en la base de datos", e);
        }
    }

    /**
     * Imprime todas las conversaciones de la tabla `conversacion` de la base de datos.
     * Cada fila de la tabla se imprime con su valor de `codigoConversacion`.
     *
     * @throws RuntimeException si ocurre un error al obtener los datos de la base de datos.
     */
    private static void imprimirConversaciones() {
        String selectSQL = "SELECT * FROM conversacion";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                Integer codigoConversacion = rs.getInt("codigoConversacion");
                System.out.println(codigoConversacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener datos de la base de datos", e);
        }
    }

    /**
     * Borra todas las filas de la tabla `conversacion` de la base de datos.
     * Imprime el número de filas afectadas por la operación de borrado.
     *
     * @throws RuntimeException si ocurre un error durante el borrado en la base de datos.
     */
    public static void borrarTodosLasConversaciones() {
        String deleteSQL = "DELETE FROM conversacion";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement()) {
            int rowsAffected = stmt.executeUpdate(deleteSQL);
            System.out.println("Se han borrado " + rowsAffected + " filas.");
        } catch (SQLException e) {
            throw new RuntimeException("Error al borrar los datos de la tabla conversacion", e);
        }
    }

}
