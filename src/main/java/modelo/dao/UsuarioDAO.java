package modelo.dao;

import java.sql.Statement;

public class UsuarioDAO implements Consulta{
    @Override
    public String setQuery() {
        // Crear un Statement para ejecutar consultas
        // Ejemplo de consulta SELECT
        return "SELECT * FROM usuario";
    }
}
