import controller.ConversacionService;
import controller.UsuarioService;
import controller.*;
import model.ConversacionModel;
import model.Usuario;
import model.UsuarioModel;
import model.dao.Conexion;
import model.dao.Consulta;
import model.dao.ConversacionDAO;
import model.dao.UsuarioDAO;
import model.dto.UsuarioDTO;

public class Main {
    public static void main(String[] args) {
        Conexion.getInstance();
        UsuarioService usuarioService = new UsuarioService();
        ConversacionModel conversacionModel = new ConversacionModel();
        UsuarioModel model = new UsuarioModel();
        /*
        UsuarioDAO.insertar(
                usuarioService.nuevoUsuario(
                        "usaurio2", "upd2", "apup2", "1234"
                )
        );
        */
        UsuarioDAO.consultar(Consulta.GET_ALL_USERS);
        model.setUsuarios(UsuarioDTO.nuevoUsuario());
        ConversacionDAO.insertarConversacion(conversacionModel.newConversacion(model.getUsuarios().getFirst(), model.getUsuarios().getLast()));
        ConversacionDAO.consultar(Consulta.GET_ALL_USERS);
    }
}
