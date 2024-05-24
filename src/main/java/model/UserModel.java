package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modelo de usuario en la aplicación de mensajería.
 */
public class UserModel {
    /**
     * Lista de usuarios en la aplicación.
     */
    public static ArrayList<User> users = new ArrayList<>();

    /**
     * Logea a un usuario en la aplicación.
     * @param userName
     * @param password
     * @return
     */
    public static boolean loggin(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve un usuario por su nombre de usuario.
     *
     * @param userName el nombre de usuario del usuario
     * @return el usuario con el nombre de usuario proporcionado
     */
    public static User getUserByUserName(String userName){
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Crea un nuevo usuario con los detalles proporcionados.
     *
     * @param userName  el nombre de usuario del usuario
     * @param firstName el nombre del usuario
     * @param surName   el apellido del usuario
     * @param password  la contraseña del usuario
     * @return el usuario creado
     */
    public static User newUser(String userName, String firstName, String surName, String password) {
        return new User(userName, firstName, surName, password);
    }

    /**
     * Añade un usuario a la lista de usuarios en la aplicación.
     *
     * @param user el usuario a añadir
     */
    public static void addUser(User user) {
        users.add(user);
    }

    /**
     * Añade un contacto a la lista de contactos de un usuario.
     *
     * @param user el usuario al que se le añade el contacto
     * @param contact el contacto a añadir
     */
    public static void addContact(User user, User contact){
        user.getContactos().add(contact);
    }

    /**
     * Añade una conversación a la lista de conversaciones de un usuario.
     *
     * @param user el usuario al que se le añade la conversación
     * @param conversacion la conversación a añadir
     */
    public static void addConversacion(User user, Conversacion conversacion){
        user.getConversaciones().add(conversacion);
    }

    /**
     * Crea una nueva conversación con los detalles proporcionados.
     *
     * @param codigoConversacion el código de la conversación
     * @param participantes lista de los participantes en la conversacion
     * @return la conversación creada
     */
    public static Conversacion newConversacion(Integer codigoConversacion, ArrayList<User> participantes){
        return new Conversacion(codigoConversacion, participantes);
    }

    /**
     * Crea un nuevo mensaje con los detalles proporcionados.
     * @param contenido el contenido del mensaje
     * @param emisor    el usuario que envió el mensaje
     * @return el mensaje creado
     */
    public static Mensaje newMensaje(String contenido, User emisor){
        return new Mensaje(contenido, emisor);
    }

    /**
     * Añade un mensaje a la lista de mensajes de una conversación.
     *
     * @param conversacion la conversación a la que se le añade el mensaje
     * @param mensaje el mensaje a añadir
     */
    public static void addMensaje(Conversacion conversacion, Mensaje mensaje){
        conversacion.getMensajes().add(mensaje);
    }

    /**
     * Devuelve la lista de usuarios en la aplicación.
     *
     * @return la lista de usuarios en la aplicación
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Establece la lista de usuarios en la aplicación.
     *
     * @param users la lista de usuarios en la aplicación
     */
    public static void setUsers(ArrayList<User> users) {
        UserModel.users = users;
    }
}
