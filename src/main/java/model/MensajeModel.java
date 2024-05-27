package model;

public class MensajeModel {
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

