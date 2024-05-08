import modelo.dao.Conexion;

public class Main {
    public static void main(String[] args) {
        Conexion.getInstance();
        Conexion.conexionInit();
    }
}
