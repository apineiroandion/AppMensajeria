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
     * Usuario que recibió el mensaje
     */
    private User receptor;
    /**
     * Fecha en la que se envió el mensaje
     */
    private String fecha;

    /**
     * Crea un nuevo mensaje con los detalles proporcionados.
     *
     * @param contenido el contenido del mensaje
     * @param emisor    el usuario que envió el mensaje
     * @param receptor  el usuario que recibió el mensaje
     * @param fecha     la fecha en la que se envió el mensaje
     */
    public Mensaje(String contenido, User emisor, User receptor, String fecha) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
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
     * Devuelve el usuario que recibió el mensaje.
     *
     * @return el usuario que recibió el mensaje
     */
    public User getReceptor() {
        return receptor;
    }
    /**
     * Establece el usuario que recibió el mensaje.
     *
     * @param receptor el usuario que recibió el mensaje
     */
    public void setReceptor(User receptor) {
        this.receptor = receptor;
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
