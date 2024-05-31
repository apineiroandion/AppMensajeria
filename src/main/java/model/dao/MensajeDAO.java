package model.dao;

import controller.UserController;
import model.Conversacion;
import model.Mensaje;
import model.User;
import model.UserModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static model.UserModel.*;

/**
 * Clase de acceso a datos para los mensajes.
 * Esta clase proporciona métodos para interactuar con la tabla de mensajes en la base de datos.
 */
public class MensajeDAO {
    /**
     * Inserta un nuevo mensaje en la base de datos.
     * Este método crea un nuevo registro en la tabla de mensajes en la base de datos.
     *
     * @param mensaje el mensaje que se va a insertar en la base de datos.
     * @param conversacion la conversación a la que pertenece el mensaje.
     * @return true si el mensaje se insertó correctamente en la base de datos, false en caso contrario.
     * @throws RuntimeException si ocurre un error al insertar el mensaje en la base de datos.
     */
    public static boolean insertMensajeIntoDB(Mensaje mensaje, Conversacion conversacion) {
        String query = "INSERT INTO mensaje (userName, fecha, contenido, codigoConversacion) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            // Configurar parámetros
            pstmt.setString(1, mensaje.getEmisor().getUserName());
            pstmt.setDate(2, java.sql.Date.valueOf(mensaje.getFecha()));
            pstmt.setString(3, mensaje.getContenido());
            pstmt.setInt(4, conversacion.getCodigoConversacion());

            // Ejecutar la actualización
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Imprimir el mensaje de error completo para depuración
            e.printStackTrace();
            throw new RuntimeException("Error al enviar Mensaje", e);
        }
    }
    /**
     * Obtiene los mensajes de una conversación específica de la base de datos.
     * Este método consulta la tabla de mensajes en la base de datos y devuelve una lista de mensajes.
     *
     * @param conversacionId el ID de la conversación para la que se van a obtener los mensajes.
     * @return ArrayList<Mensaje> la lista de mensajes obtenidos de la base de datos.
     * @throws RuntimeException si ocurre un error al obtener los mensajes de la base de datos.
     */
    public static ArrayList<Mensaje> getMensajesFromDB(Integer conversacionId) {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        String query = "SELECT * FROM mensaje WHERE codigoConversacion = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, conversacionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String userName = rs.getString("username");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    String contenido = rs.getString("contenido");
                    Integer codigoConversacion = rs.getInt("codigoconversacion");

                    User userAux = null;
                    for (User user : users) {
                        if (userName.equals(user.getUserName())) {
                            userAux = user;
                            break;
                        }
                    }

                    Mensaje mensaje = new Mensaje(contenido, userAux);
                    mensajes.add(mensaje);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar los mensajes de la conversación", e);
        }
        return mensajes;
    }
    /**
     * Obtiene los mensajes sin ler de una conversación específica de la base de datos.
     * Este método consulta la tabla de mensajes en la base de datos y devuelve una lista de mensajes.
     * @param conversacionId el ID de la conversación para la que se van a obtener los mensajes.
     * @return ArrayList<Mensaje> la lista de mensajes obtenidos de la base de datos.
     * @throws RuntimeException si ocurre un error al obtener los mensajes de la base de datos.
     */
    public static boolean getMensajesSinLeerFromDB(Integer conversacionId) {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        String query = "SELECT * FROM mensaje WHERE codigoConversacion = ? AND leido = false";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, conversacionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String userName = rs.getString("userName");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    String contenido = rs.getString("contenido");
                    Integer codigoConversacion = rs.getInt("codigoConversacion");

                    User userAux = null;
                    for (User user : users) {
                        if (userName.equals(user.getUserName())) {
                            userAux = user;
                            break;
                        }
                    }

                    Mensaje mensaje = new Mensaje(contenido, userAux);
                    mensajes.add(mensaje);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar los mensajes de la conversación", e);
        }
        if (mensajes == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Marca los mensajes de una conversación como leídos en la base de datos.
     * Este método actualiza el campo "leido" de los mensajes de una conversación en la base de datos.
     * @param conversacionId el ID de la conversación para la que se van a marcar los mensajes como leídos.
     * @return true si los mensajes se marcaron correctamente como leídos en la base de datos, false en caso contrario.
     * @throws RuntimeException si ocurre un error al marcar los mensajes como leídos en la base de datos.
     */
    public static boolean marcarMensajesComoLeidos(Integer conversacionId) {
        String query = "UPDATE mensaje SET leido = true WHERE codigoConversacion = ? AND userName != ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, conversacionId);
            pstmt.setString(2, UserController.usuarioLogeado.getUserName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al marcar los mensajes como leídos", e);
        }
    }

    /**
     * Metodo que devuelve una lista de id de conversaciones donde hay mensajes sin leer y que el usuario que los envia
     * sea distinto al usuario logeado
     * @param userName
     * @return lista de id de conversaciones
     */
    public static ArrayList<Integer> getConversacionesConMensajesSinLeer(String userName) {
        ArrayList<Integer> conversaciones = new ArrayList<>();
        String query = "SELECT codigoConversacion FROM mensaje WHERE userName = ? AND leido = false";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, userName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Integer codigoConversacion = rs.getInt("codigoConversacion");
                    conversaciones.add(codigoConversacion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar las conversaciones con mensajes sin leer", e);
        }
        return conversaciones;
    }

    /**
     * Metodo que comprueba si una conversacion tiene mensajes sin leer y si el usuario logeado no es el que envio el mensaje
     * @param conversacionId
     * @return true si hay mensajes sin leer y el usuario que los envia es distinto al usuario logeado
     */
    public static boolean hayMensajesNoLeidos(Integer conversacionId) {
        String query = "SELECT * FROM mensaje WHERE codigoConversacion = ? AND leido = false";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, conversacionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String userName = rs.getString("userName");
                    if (!userName.equals(UserController.usuarioLogeado.getUserName())) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar los mensajes sin leer", e);
        }
        return false;
    }

}
