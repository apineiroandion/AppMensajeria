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
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO mensaje (userName, fecha, contenido, codigoConversacion) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, mensaje.getEmisor().getUserName());
            pstmt.setString(2,mensaje.getFecha().toString());
            pstmt.setString(3, mensaje.getContenido());
            pstmt.setInt(4, conversacion.getCodigoConversacion());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar Mensaje");
        }
    }
    public static ArrayList<Mensaje> getMensajesFromDB(Integer conversacionId) {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM mensaje WHERE codigoConversacion = ?")){

            while (rs.next()) {
                String userName = rs.getString("userName");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                String contenido = rs.getString("contenido");
                Integer codigoConversacion = rs.getInt("codigoConversacion");
                ArrayList<User> usersAux = users;
                User userAux = null;
                for (int i = 0; i < usersAux.size(); i++) {
                    if (userName.equals(usersAux.get(i).getUserName())) {
                        userAux = usersAux.get(i);
                    }
                }
                Mensaje mensaje = new Mensaje(contenido, userAux);
                mensajes.add(mensaje);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar las mensajes de la conversacion");
        }
        return mensajes;
    }
}
