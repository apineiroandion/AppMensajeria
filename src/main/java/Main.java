import modelo.dao.Conexion;
import modelo.dao.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        Conexion.getInstance();
        //Conexion.insertar();
        Conexion.conexionInit(new UsuarioDAO());
    }
}
