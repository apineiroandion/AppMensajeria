package model;

import java.util.ArrayList;

/**
 * Esta calse representa un usuario de la aplicaccion.
 * Contiene la informacion basica del usuario
 */
public class Usuario {
    /**
     * id de usuario
     */
    private Integer idu;
    /**
     * nombre unico de usuario
     */
    private String userName;
    /**
     * nombre real usuario
     */
    private String firstName;
    /**
     * apellido usuario
     */
    private String surName;
    /**
     * contraseña del usuario
     */
    private String password;
    /**
     * Lista de conversaciones
     */
    private ArrayList<Conversacion> conversaciones;

    /**
     * Constructor para crear un objeto del tipo usuario
     *
     * @param userName
     * @param firstName
     * @param surName
     * @param password
     */
    public Usuario(Integer idu, String userName, String firstName, String surName, String password) {
        this.idu = idu;
        this.userName = userName;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
        this.conversaciones = new ArrayList<>();
    }

    public Usuario(String userName, String firstName, String surName, String password, ArrayList<Conversacion> conversaciones) {
        this.userName = userName;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
        this.conversaciones = conversaciones;
    }
    //Metodos de acceso

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Conversacion> getConversaciones() {
        return conversaciones;
    }

    public void setConversaciones(ArrayList<Conversacion> conversaciones) {
        this.conversaciones = conversaciones;
    }
}
