package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ESta calse realiza la conexion con la base de datos
 */
public class Connection {
    /**
     * url de la base de datos externa
     */
    private String url = "jdbc:postgresql://140.238.65.12:80/bason";
    /**
     * nombre de usuario de la base de datos
     */
    private String user = "postgres";
    /**
     * contraseña del usuario de la base de datos
     */
    private String password = "postgres";
    /**
     * instancia de la clase Coneccion
     */
    private static Connection connection;

    /**
     * COnstructor privado
     */
    private Connection() {
    }

    /**
     * getInstance
     * @return Clase con las funciones de conexion con la BD
     */
    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    /**
     * Clase que inicia y cierra la conexion con la base de datos
     */
    public static void conexionInit(){
        try{
            Connection con = (Connection) DriverManager.getConnection(connection.url, connection.user, connection.password);
            System.out.println("Conectao");
            //Introducir consultas
            DriverManager.getConnection(connection.url).close();
        }catch(SQLException e){
            e.printStackTrace();
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

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Connection.connection = connection;
    }
}
