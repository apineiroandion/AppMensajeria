package model;

public class ConversacionModel {
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
}
