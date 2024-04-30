package servicio;

import modelo.Conversacion;
import modelo.Mensaje;
import modelo.Usuario;

public class UsuarioService {

    /**
     * Crea una nueva conversacion entre dos usuarios
     * @param usuarioDos
     * @return conversacion nueva con usuario seleccionado
     */
    public Conversacion newConversacion(Usuario usuarioUno, Usuario usuarioDos) {
        Conversacion conversacion = new Conversacion(usuarioUno, usuarioDos);
        return conversacion;
    }

    /**
     * Añade la conversacion a los array list de los dos usuarios, recomemçndable usara como parametro el
     * metodo newConversacion
     * @param conversacion
     */
    public void addConversacion(Conversacion conversacion) {
        //añado la conversacion seleccionada al array list de conversaciones de este usuario
        conversacion.getUsuarioUno().getConversaciones().add(conversacion);
        //añado la conversacion al arry list del ususario dos
        conversacion.getUsuarioDos().getConversaciones().add(conversacion);
    }

    /**
     * Añade un mensaje a la conversacion seleccionada
     * @param conversacion
     * @param textoMensaje
     */
    public void newMensaje(Usuario usuario, Conversacion conversacion, String textoMensaje) {
        Mensaje mensaje = new Mensaje(conversacion.getIdc(), usuario.getIdu(), textoMensaje);
        conversacion.getMensajes().add(mensaje);
    }
}
