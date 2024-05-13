package model.dao;

import model.Conversacion;

import java.sql.*;

import static model.dao.UsuarioDAO.comprobarInsercion;

public class ConversacionDAO implements Consulta{
    //TODO : Metodos de transferencaia con la DB


    @Override
    public String getQuery(String query) {
        return query;
    }

    public static void insertarConversacion(Conversacion conversacion) {
        try{
            Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                    Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
            System.out.println("Conectado");
            String insert = "insert into conversacion (idu1, idu2) VALUES (?,?)";
            PreparedStatement pstmt = con.prepareStatement(insert);
            pstmt.setString(1, conversacion.getUsuarioUno().getIdu().toString());
            pstmt.setString(2, conversacion.getUsuarioDos().getIdu().toString());
            int filasAfectadas = pstmt.executeUpdate();
            comprobarInsercion(filasAfectadas);
            pstmt.close();
            con.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void consultar(String query) {
        try {
            Connection con = DriverManager.getConnection(Conexion.getConnection().getUrl(),
                    Conexion.getConnection().getUser(), Conexion.getConnection().getPassword());
            System.out.println("Conectado");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Procesar los resultados de la consulta
            while (rs.next()) {
                // Accede a los datos de cada fila
                int id = rs.getInt("idc");
                String usuarioUno = rs.getString("idu1");
                String usuarioDos = rs.getString("idu2");
                // Hacer algo con los datos...
                System.out.println("ID: " + id + ", id usuario 1: " + usuarioUno + ", id usuario 2: " + usuarioDos);
            }
            // Cerrar ResultSet, Statement y conexión
            rs.close();
            stmt.close();
            con.close(); // Cierra la conexión
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Fin metodo");
    }

}
