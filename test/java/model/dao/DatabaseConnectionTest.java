package model.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnectionTest {

    @Test
    void testGetConnection() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            assertNotNull(conn, "La conexión no debería ser nula");
            assertFalse(conn.isClosed(), "La conexión debería estar abierta");
        } catch (SQLException e) {
            fail("No se pudo establecer la conexión a la base de datos: " + e.getMessage());
        }
    }

}
