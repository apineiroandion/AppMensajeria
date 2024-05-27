package model.dao;

import model.Conversacion;
import model.Mensaje;
import model.User;
import model.UserModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static model.UserModel.*;


public class MensajeDAO {
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
    public static ArrayList<Mensaje> getMensajesFromDB(Integer conversacionId) {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        String query = "SELECT * FROM mensaje WHERE codigoConversacion = ?";

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
        return mensajes;
    }

}
