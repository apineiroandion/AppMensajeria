package model.dao;

import model.Conversacion;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                // Asume que tienes un constructor adecuado o métodos setter para establecer los valores de las columnas
                Conversacion conversacion = new Conversacion(codigoConversacion, participantes.getFirst(), participantes.getLast());
                // Asegúrate de que los nombres de las columnas coinciden con los de tu tabla de conversaciones
                conversaciones.add(conversacion);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener conversaciones del usuario de la base de datos", e);
        }
        return conversaciones;
    }
}
