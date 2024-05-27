package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Conexion Con la Base de Datos
 */
public class DatabaseConnection {
    /**
     * URL de la bd
     */
    private static final String DATABASE_URL = "jdbc:postgresql://140.238.65.12:5432/bason";
    /**
     * Usuario postgress
     */
    private static final String DATABASE_USER = "postgres";
    /**
     * Contraseña usuario Postgres
     */
    private static final String DATABASE_PASSWORD = "contraseñasegura";

    /**
     * get Conecction
     * @return Conexion
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

}