package model;

import java.util.ArrayList;

/**
 * Representa a un usuario en la aplicación de mensajería.
 */
public class User {
    /**
     * Nombre UNICO de usuario
     */
    private String userName;
    /**
     * nombre real del usuaqrio
     */
    private String firstName;
    /**
     * apellido del usuario
     */
    private String surName;
    /**
     * contraseña del usuario
     */
    private String password;
    /**
     * lista de conversaciones
     */
    private ArrayList<Conversacion> conversaciones = new ArrayList<>();
    /**
     * Lista de contactos
     */
    private ArrayList<User> contactos = new ArrayList<>();

    /**
     * Crea un nuevo usuario con los detalles proporcionados.
     *
     * @param userName  el nombre de usuario del usuario
     * @param firstName el nombre del usuario
     * @param surName   el apellido del usuario
     * @param password  la contraseña del usuario
     */
    public User(String userName, String firstName, String surName, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
    }

    /**
     * Devuelve el nombre de usuario del usuario.
     *
     * @return el nombre de usuario del usuario
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Establece el nombre de usuario del usuario.
     *
     * @param userName el nuevo nombre de usuario del usuario
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param firstName el nuevo nombre del usuario
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Devuelve el apellido del usuario.
     *
     * @return el apellido del usuario
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param surName el nuevo apellido del usuario
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return la contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password la nueva contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Devuelve la lista de conversaciones del usuario.
     *
     * @return la lista de conversaciones del usuario
     */
    public ArrayList<Conversacion> getConversaciones() {
        return conversaciones;
    }
    /**
     * Establece la lista de conversaciones del usuario.
     *
     * @param conversaciones la nueva lista de conversaciones del usuario
     */
    public void setConversaciones(ArrayList<Conversacion> conversaciones) {
        this.conversaciones = conversaciones;
    }
/**
     * Devuelve la lista de contactos del usuario.
     *
     * @return la lista de contactos del usuario
     */
    public ArrayList<User> getContactos() {
        return contactos;
    }

    /**
     * Establece la lista de contactos del usuario.
     *
     * @param contactos la nueva lista de contactos del usuario
     */
    public void setContactos(ArrayList<User> contactos) {
        this.contactos = contactos;
    }
}