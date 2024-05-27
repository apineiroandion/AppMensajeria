package model.dto;

import model.Conversacion;
import model.Usuario;
import model.dao.Conexion;
import model.dao.Consulta;

import java.sql.*;
import java.util.ArrayList;

public class ConversacionDTO implements Consulta {
    @Override
    public String getQuery(String query) {
        return query;
    }

    public static void insertarConversacion(Conversacion conversacion) {
        String insert = "INSERT INTO conversacion (idu1, idu2) VALUES (?,?)";
        try (Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
             PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, conversacion.getUsuarioUno().getIdu());
            pstmt.setInt(2, conversacion.getUsuarioDos().getIdu());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar la conversación", e);
        }
    }

    public static ArrayList<Conversacion> obtenerConversaciones(Usuario usuarioUno, Usuario usuarioDos) {
        ArrayList<Conversacion> conversaciones = new ArrayList<>();
        String query = "SELECT * FROM conversacion";
        try (Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int idc = rs.getInt("idc");
                int idu1 = rs.getInt("idu1");
                int idu2 = rs.getInt("idu2");
                if (idu1 != usuarioUno.getIdu() || idu2 != usuarioDos.getIdu()) {
                    continue;
                }
                Conversacion conversacion = new Conversacion(usuarioUno, usuarioDos);
                conversaciones.add(conversacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener las conversaciones", e);
        }
        return conversaciones;
    }

    public static void actualizarConversacion(Conversacion conversacion) {
        String update = "UPDATE conversacion SET idu1 = ?, idu2 = ? WHERE idc = ?";
        try (Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
             PreparedStatement pstmt = con.prepareStatement(update)) {
            pstmt.setInt(1, conversacion.getUsuarioUno().getIdu());
            pstmt.setInt(2, conversacion.getUsuarioDos().getIdu());
            pstmt.setInt(3, conversacion.getIdc());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la conversación", e);
        }
    }

    public static void eliminarConversacion(int idc) {
        String delete = "DELETE FROM conversacion WHERE idc = ?";
        try (Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
             PreparedStatement pstmt = con.prepareStatement(delete)) {
            pstmt.setInt(1, idc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la conversación", e);
        }
    }
}
