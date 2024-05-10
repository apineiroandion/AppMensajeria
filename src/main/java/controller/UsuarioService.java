package controller;

import model.Conversacion;
import model.Mensaje;
import model.Usuario;

/**
 * Esta clase proporciona servicios relacionados con la gestión de usuarios en el sistema.
 * Permite crear, actualizar y eliminar usuarios, así como realizar otras operaciones
 * relacionadas con los usuarios.
 */
public class UsuarioService {
    //TODO : Meter Treads en controller

    /**
     * Metodo que crea un nuevo ususario
     * @param userName
     * @param firstName
     * @param surName
     * @param password
     * @return el usuario creado
     */
    public Usuario nuevoUsuario(String userName, String firstName, String surName, String password){
        return new Usuario(userName, firstName, surName, password);
    }
    /**
     * Crea una nueva conversacion entre dos usuarios
     * @param usuarioUno
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
     * Crea un nuevo mensaje
     * @param conversacion
     * @param textoMensaje
     * @return el mensaje nuevo
     */
    public Mensaje newMensaje(Usuario usuario, Conversacion conversacion, String textoMensaje) {
        return new Mensaje(conversacion.getIdc(), usuario.getIdu(), textoMensaje);
    }

    /**
     * Añade un mensaje a la conversacion seleccionada
     * @param conversacion
     * @param mensaje
     */
    public void addMensaje(Conversacion conversacion, Mensaje mensaje) {
        conversacion.getMensajes().add(mensaje);
    }
}
