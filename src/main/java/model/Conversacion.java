package model;

import java.util.ArrayList;

/**
 * Representa una conversación entre dos usuarios.
 */
public class Conversacion {
    /**
     * Código único de la conversación
     */
    private Integer codigoConversacion;
    /**
     * ArrayList de Users que participan en la conversacion
     */
    private ArrayList<User> participantes;
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
    public Conversacion(Integer codigoConversacion, User user1, User user2) {
        this.codigoConversacion = codigoConversacion;
        participantes = new ArrayList<>();
        participantes.add(user1);
        participantes.add(user2);
        this.mensajes = new ArrayList<>();
    }
    /**
     * Devuelve el código de la conversación.
     *
     * @return el código de la conversación
     */
    public Integer getCodigoConversacion() {
        return codigoConversacion;
    }
    /**
     * Establece el código de la conversación.
     *
     * @param codigoConversacion el código de la conversación
     */
    public void setCodigoConversacion(Integer codigoConversacion) {
        this.codigoConversacion = codigoConversacion;
    }

    /**
     * Devuelve el array de participantes
     * @return
     */
    public ArrayList<User> getParticipantes() {
        return participantes;
    }

    /**
     * Establece los participantes de la conversacoion
     * @param participantes
     */
    public void setParticipantes(ArrayList<User> participantes) {
        this.participantes = participantes;
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
