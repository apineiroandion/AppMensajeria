package modelo;

import java.util.ArrayList;

public class Usuario {
    private Integer idu;
    private String userName;
    private String firstName;
    private String surname;
    private String password;
    private ArrayList<Conversacion> conversaciones;

    public Usuario(Integer idu, String userName, String firstName, String surname, String password) {
        this.idu = idu;
        this.userName = userName;
        this.firstName = firstName;
        this.surname = surname;
        this.password = password;
        this.conversaciones = new ArrayList<>();
    }

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
