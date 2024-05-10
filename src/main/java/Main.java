import controller.UsuarioService;
import model.Usuario;
import model.dao.Conexion;
import model.dao.Consulta;
import model.dao.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        Conexion.getInstance();
        UsuarioService usuarioService = new UsuarioService();
        /*
        UsuarioDAO.insertar(
                usuarioService.nuevoUsuario(
                        "usaurio2", "upd2", "apup2", "1234"
                )
        );
        */
        UsuarioDAO.consultar(Consulta.GET_ALL_USERS);
    }
}
