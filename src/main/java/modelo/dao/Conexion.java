package modelo.dao;

import java.sql.*;

/**
 * ESta calse realiza la conexion con la base de datos
 */
public class Conexion {
    /**
     * url de la base de datos externa
     */
    private String url = "jdbc:postgresql://140.238.65.12:5432/bason";
    /**
     * nombre de usuario de la base de datos
     */
    private String user = "postgres";
    /**
     * contraseña del usuario de la base de datos
     */
    private String password = "contraseñasegura";
    /**
     * instancia de la clase Coneccion
     */
    private static Conexion conexion;

    /**
     * COnstructor privado
     */
    private Conexion() {
    }

    /**
     * getInstance
     * @return Clase con las funciones de conexion con la BD
     */
    public static Conexion getInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    /**
     * Clase que inicia y cierra la conexion con la base de datos
     */
    public static void conexionInit(Consulta consulta) {
        try {
            Connection con = DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword());
            System.out.println("Conectado");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta.setQuery());
            // Procesar los resultados de la consulta
            while (rs.next()) {
                // Accede a los datos de cada fila
                int id = rs.getInt("idu");
                String nombre = rs.getString("userName");
                // Hacer algo con los datos...
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + rs.getString("surname"));
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
    //TODO : Actualizar metodo para que inserte cosas
    public static void insertar() {
        try {
        Connection con = DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword());
        System.out.println("Conectado");
        String insert = "insert into usuario (userName, firstName, surname, password) VALUES (?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(insert);
        pstmt.setString(1, "userName");
        pstmt.setString(2, "firstName");
        pstmt.setString(3, "surname");
        pstmt.setString(4, "password");

            // Ejecutar la consulta de inserción
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa");
            } else {
                System.out.println("La inserción no tuvo éxito");
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Getters y Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Conexion getConnection() {
        return conexion;
    }

    public static void setConnection(Conexion conexion) {
        Conexion.conexion = conexion;
    }
}
