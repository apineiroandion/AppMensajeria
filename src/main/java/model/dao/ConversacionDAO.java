package model.dao;

import model.Conversacion;

import java.sql.*;

import static model.dao.UsuarioDAO.comprobarInsercion;

public class ConversacionDAO implements Consulta {

    @Override
    public String getQuery(String query) {
        return query;
    }

    public static void insertarConversacion(Conversacion conversacion) {
        String insert = "insert into conversacion (idu1, idu2) VALUES (?,?)";
        try (Connection con = createConnection();
             PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setString(1, conversacion.getUsuarioUno().getIdu().toString());
            pstmt.setString(2, conversacion.getUsuarioDos().getIdu().toString());
            int filasAfectadas = pstmt.executeUpdate();
            comprobarInsercion(filasAfectadas);
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar la conversación", e);
        }
    }

    public static void consultar(String query) {
        try (Connection con = createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("idc");
                String usuarioUno = rs.getString("idu1");
                String usuarioDos = rs.getString("idu2");
                System.out.println("ID: " + id + ", id usuario 1: " + usuarioUno + ", id usuario 2: " + usuarioDos);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar", e);
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(Conexion.getConnection().getUrl(),
                Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
    }
}