package model;

import java.util.ArrayList;

/**
 * Representa una conversación entre dos usuarios.
 */
public class Conversacion {
    /**
     * Código único de la conversación
     */
    private String codigoConversacion;
    /**
     * Usuario 1 en la conversación
     */
    private User user1;
    /**
     * Usuario 2 en la conversación
     */
    private User user2;
    /**
     * Lista de mensajes en la conversación
     */
    private ArrayList<Mensaje> mensajes;
    /**
     * Crea una nueva conversación con los detalles proporcionados.
     *
     * @param codigoConversacion el código de la conversación
     * @param user1              el primer usuario en la conversación
     * @param user2              el segundo usuario en la conversación
     */
    public Conversacion(String codigoConversacion, User user1, User user2) {
        this.codigoConversacion = codigoConversacion;
        this.user1 = user1;
        this.user2 = user2;
        this.mensajes = new ArrayList<>();
    }
    /**
     * Devuelve el código de la conversación.
     *
     * @return el código de la conversación
     */
    public String getCodigoConversacion() {
        return codigoConversacion;
    }
    /**
     * Establece el código de la conversación.
     *
     * @param codigoConversacion el código de la conversación
     */
    public void setCodigoConversacion(String codigoConversacion) {
        this.codigoConversacion = codigoConversacion;
    }
    /**
     * Devuelve el primer usuario en la conversación.
     *
     * @return el primer usuario en la conversación
     */
    public User getUser1() {
        return user1;
    }
    /**
     * Establece el primer usuario en la conversación.
     *
     * @param user1 el primer usuario en la conversación
     */
    public void setUser1(User user1) {
        this.user1 = user1;
    }
    /**
     * Devuelve el segundo usuario en la conversación.
     *
     * @return el segundo usuario en la conversación
     */
    public User getUser2() {
        return user2;
    }
    /**
     * Establece el segundo usuario en la conversación.
     *
     * @param user2 el segundo usuario en la conversación
     */
    public void setUser2(User user2) {
        this.user2 = user2;
    }
    /**
     * Devuelve la lista de mensajes en la conversación.
     *
     * @return la lista de mensajes en la conversación
     */
    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }
    /**
     * Establece la lista de mensajes en la conversación.
     *
     * @param mensajes la nueva lista de mensajes en la conversación
     */
    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
