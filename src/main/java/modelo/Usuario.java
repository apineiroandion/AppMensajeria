package modelo;

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
    private String surname;
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
     * @param idu
     * @param userName
     * @param firstName
     * @param surname
     * @param password
     */
    public Usuario(Integer idu, String userName, String firstName, String surname, String password) {
        this.idu = idu;
        this.userName = userName;
        this.firstName = firstName;
        this.surname = surname;
        this.password = password;
        this.conversaciones = new ArrayList<>();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
