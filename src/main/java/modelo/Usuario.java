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
    }

    /**
     * Crea una nueva conversacion del usuario que llama al metodo con el usuario seleccionado
     * @param usuarioDos
     * @return conversacion nueva con usuario seleccionado
     */
    public Conversacion newConversacion(Usuario usuarioDos) {
        Conversacion conversacion = new Conversacion(this, usuarioDos);
        return conversacion;
    }

    /**
     * Añade la conversacion a los array list de los dos usuarios, recomemçndable usara como parametro el
     * metodo newConversacion
     * @param conversacion
     */
    public void addConversacion(Conversacion conversacion) {
        //añado la conversacion seleccionada al array list de conversaciones de este usuario
        this.conversaciones.add(conversacion);
        //añado la conversacion al arry list del ususario dos
        conversacion.getUsuarioDos().conversaciones.add(conversacion);
    }

    /**
     * Añade un mensaje a la conversacion seleccionada
     * @param conversacion
     * @param textoMensaje
     */
    public void newMensaje(Conversacion conversacion, String textoMensaje) {
        Mensaje mensaje = new Mensaje(conversacion.getIdc(), this.idu, textoMensaje);
        conversacion.getMensajes().add(mensaje);
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
}
