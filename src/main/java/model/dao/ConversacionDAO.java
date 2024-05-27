package model.dao;

import model.Conversacion;
import model.Mensaje;
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
     * Obtiene una conversación específica de la base de datos utilizando su código de conversación.
     * Este método consulta la tabla 'tienen' en la base de datos y devuelve un objeto Conversacion.
     *
     * @param codigoConversacion el código de la conversación que se va a obtener de la base de datos.
     * @return Conversacion el objeto Conversacion que representa la conversación obtenida de la base de datos.
     * @throws RuntimeException si ocurre un error al obtener la conversación de la base de datos.
     */
    public static Conversacion getConversacionByCodigoConversacionFromDB(Integer codigoConversacion) {
        Conversacion conversacion = null;
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tienen WHERE codigoConversacion = ?")) {

            pstmt.setInt(1, codigoConversacion);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<User> participantes = UserDAO.getUserByConversationFromDB(codigoConversacion);
            conversacion = new Conversacion(codigoConversacion, participantes);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener conversación de la base de datos", e);
        }
        return conversacion;
    }

    /**
     * Obtiene una conversación específica de la base de datos utilizando su código de conversación.
     * Este método consulta la tabla 'tienen' en la base de datos y devuelve un objeto Conversacion.
     *
     * @param codigoConversacion el código de la conversación que se va a obtener de la base de datos.
     * @return Conversacion el objeto Conversacion que representa la conversación obtenida de la base de datos.
     * @throws RuntimeException si ocurre un error al obtener la conversación de la base de datos.
     */
    public static Conversacion getConversacionByCodigoConversacionFromDBWithMensajes(Integer codigoConversacion) {
        Conversacion conversacion = null;
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tienen WHERE codigoConversacion = ?")) {

            pstmt.setInt(1, codigoConversacion);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<User> participantes = UserDAO.getUserByConversationFromDB(codigoConversacion);
            ArrayList<Mensaje> mensajes = MensajeDAO.getMensajesFromDB(codigoConversacion);
            conversacion = new Conversacion(codigoConversacion, participantes);
            conversacion.setMensajes(mensajes);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener conversación de la base de datos", e);
        }
        return conversacion;
    }
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
                Conversacion conversacion = new Conversacion(codigoConversacion, participantes);
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
        insertarConversacionSinDatos();
        imprimirConversaciones();
    }

    /**
     * Inserta una nueva conversación en la tabla `conversacion` de la base de datos.
     * La columna `codigoConversacion` es de tipo SERIAL y se genera automáticamente.
     *
     * @throws RuntimeException si ocurre un error durante la inserción en la base de datos.
     */
    private static void insertarConversacionSinDatos() {
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

    /**
     * Inserta una nueva conversación entre dos usuarios en la base de datos.
     *
     * @param userName1 El nombre de usuario del primer participante.
     * @param userName2 El nombre de usuario del segundo participante.
     * @return true si la conversación se insertó correctamente, false en caso contrario.
     */
    public static boolean insertarConversacion(String userName1, String userName2) {
        String insertConversationSQL = "INSERT INTO conversacion DEFAULT VALUES RETURNING codigoConversacion";
        String insertUserConversationSQL = "INSERT INTO tienen (codigoConversacion, userName) VALUES (?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmtConversation = con.prepareStatement(insertConversationSQL);
             PreparedStatement pstmtUserConversation = con.prepareStatement(insertUserConversationSQL)) {

            // Insertar nueva conversación y obtener el ID generado
            ResultSet rs = pstmtConversation.executeQuery();
            int codigoConversacion;
            if (rs.next()) {
                codigoConversacion = rs.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID de la nueva conversación");
            }

            // Insertar el primer usuario en la conversación
            pstmtUserConversation.setInt(1, codigoConversacion);
            pstmtUserConversation.setString(2, userName1);
            pstmtUserConversation.executeUpdate();

            // Insertar el segundo usuario en la conversación
            pstmtUserConversation.setInt(1, codigoConversacion);
            pstmtUserConversation.setString(2, userName2);
            pstmtUserConversation.executeUpdate();

            return true; // Si se ejecutó correctamente, devolvemos true

        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir la excepción para el registro de errores
            return false; // Si ocurrió un error, devolvemos false
        }
    }

    /**
     * Metodo que obtiene el codigo de una conversacion de la base de datos, pasandole los dos usuarios que esta en la tabla tienen
     * @param userName1
     * @param userName2
     * @return conversationId
     */
    public static Integer getConversationId(String userName1, String userName2) {
        Integer conversationId = null;
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT codigoConversacion FROM tienen WHERE userName = ? INTERSECT SELECT codigoConversacion FROM tienen WHERE userName = ?")) {

            pstmt.setString(1, userName1);
            pstmt.setString(2, userName2);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                conversationId = rs.getInt("codigoConversacion");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el codigo de la conversacion de la base de datos", e);
        }
        return conversationId;
    }


}
