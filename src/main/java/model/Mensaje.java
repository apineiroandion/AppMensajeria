package model;

import java.util.ArrayList;

public class Mensaje {
    /**
     * Contenido del mensaje
     */
    private String contenido;
    /**
     * Usuario que envió el mensaje
     */
    private User emisor;
    /**
     * Fecha en la que se envió el mensaje
     */
    private String fecha;

    /**
     * Crea un nuevo mensaje con los detalles proporcionados.
     *
     * @param contenido el contenido del mensaje
     * @param emisor    el usuario que envió el mensaje
     * @param fecha     la fecha en la que se envió el mensaje
     */
    public Mensaje(String contenido, User emisor, String fecha) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.fecha = fecha;
    }
    /**
     * Devuelve el contenido del mensaje.
     *
     * @return el contenido del mensaje
     */
    public String getContenido() {
        return contenido;
    }
    /**
     * Establece el contenido del mensaje.
     *
     * @param contenido el contenido del mensaje
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    /**
     * Devuelve el usuario que envió el mensaje.
     *
     * @return el usuario que envió el mensaje
     */
    public User getEmisor() {
        return emisor;
    }
    /**
     * Establece el usuario que envió el mensaje.
     *
     * @param emisor el usuario que envió el mensaje
     */
    public void setEmisor(User emisor) {
        this.emisor = emisor;
    }
    /**
     * Devuelve la fecha en la que se envió el mensaje.
     *
     * @return la fecha en la que se envió el mensaje
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Establece la fecha en la que se envió el mensaje.
     *
     * @param fecha la fecha en la que se envió el mensaje
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
