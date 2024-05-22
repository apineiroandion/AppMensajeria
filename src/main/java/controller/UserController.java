package controller;

import model.Conversacion;
import model.Mensaje;
import model.User;
import model.UserModel;
import model.dao.ConversacionDAO;
import model.dao.DatabaseConnection;
import model.dao.MensajeDAO;
import model.dao.UserDAO;
import view.LoginWindow;
import view.MainWindow;
import view.RegisterWindow;

import java.sql.*;
import java.util.ArrayList;

import static model.UserModel.users;

public class UserController {
    /**
     * El usuario que ha iniciado sesión en la aplicación.
     */
    public static User usuarioLogeado;
    public static ArrayList<Conversacion> conversacionesUsuarioLogeado = new ArrayList<>();

    public static void iniciarApp(){
        System.out.println("Iniciando la aplicación...");
        /*
        User user1 = new User("user1", "User", "One", "password");
        users.add(user1);
        UserDAO.addUserToDB(user1);
        */
        /*
        UserDAO.deleteAllUsersFromDB();
        users = UserDAO.getUserFromDB();
        System.out.println(users.get(1).getUserName().toString());
        */
        //UserDAO.addUserToDB(new User("UsuarioPrueba", "usuario", "prueba", "1234"));
        openLoginWindow();
    }

    /**
     * Comprueba si un usuario puede logearse en la aplicación.
     *
     * @param userName el nombre de usuario del usuario
     * @param password la contraseña del usuario
     */
    public static void comprobarlogin(String userName, String password){
        volvadoDatosLogin(userName, password);
        if(UserModel.loggin(userName, password)){
            System.out.println("Usuario logeado");
            openMainWindow();
        }else{
            System.out.println("Usuario no logeado");
        }
    }
    /**
     * Abre una nueva ventana de inicio de sesión.
     */
    public static void openLoginWindow(){
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }
    /**
     * Abre una nueva ventana de registro de Usuario.
     */
    public static void openRegisterWindow(){
        RegisterWindow registerWindow = new RegisterWindow();
        registerWindow.setVisible(true);
    }
    /**
     * Abre una nueva ventana de aplicacion.
     */
    public static void openMainWindow(){
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

    /**
     * Comprueba si el usuario que intentar loggear en la app esta en la base de datos
     * @param userName
     * @param password
     * @return El usuario para meterlo en el ArrayList local de usuarios
     */
    public static User loginInDB(String userName, String password){
        return UserDAO.getUserForLogin(userName, password);
    }

    /**
     * Coge la entity de la DB, la convierte en un objeto y lo mete dentro del array de usuarios
     * hace que el usuario logeado sea el usuario que se acaba de logear
     * @param userName
     * @param password
     * @return boolean conforme la operacion se ha relaizado con exito
     */
    public static boolean volvadoDatosLogin(String userName,String password){
        User user= loginInDB(userName, password);
        if(user != null){
            users.add(user);
            usuarioLogeado = user;
            conversacionesUsuarioLogeado = getConversacionesUsuarioLogeado(usuarioLogeado);
            getMesajesForUserConversations(conversacionesUsuarioLogeado);
            return true;
        }else{
            System.out.println("Usuario o contraseña incorrecta");
            return false;
        }
    }
    /**
     * Registra un nuevo usuario en la base de datos.
     * Este método crea un nuevo objeto User y lo añade a la base de datos.
     *
     * @param userName el nombre de usuario del nuevo usuario.
     * @param firstName el nombre del nuevo usuario.
     * @param surname el apellido del nuevo usuario.
     * @param password la contraseña del nuevo usuario.
     * @return true si el usuario se registró correctamente en la base de datos, false en caso contrario.
     */
    public static boolean registrarUsuario(String userName,String firstName, String surname, String password){
        return UserDAO.addUserToDB(new User(userName,firstName,surname,password));
    }
    /**
     * Comprueba si un usuario se registró correctamente en la base de datos.
     * Este método intenta registrar un nuevo usuario y luego imprime un mensaje basado en el resultado.
     *
     * @param userName el nombre de usuario del nuevo usuario.
     * @param firstName el nombre del nuevo usuario.
     * @param surname el apellido del nuevo usuario.
     * @param password la contraseña del nuevo usuario.
     */
    public static void comprobarRegistro(String userName,String firstName, String surname, String password){
        boolean comprobar = registrarUsuario(userName,firstName,surname,password);
        if(comprobar){
            System.out.println("Usuario registrado");
        }else{
            System.out.println("Error al registrar el usuario");
        }
    }

    /**
     * Comprueba si el emisor del mensaje es el usuario que se logeo en la app
     * @param mensaje
     * @return true si el emisor del mensaje es el usuario logeado
     */
    public static boolean comprobarEmisorMensaje(Mensaje mensaje) {
        return mensaje.getEmisor().getUserName().equals(usuarioLogeado.getUserName());
    }

    /**
     * Cargar en arrayList las conversacoiones del usuarioq ue estan en base de datos
     * @param user
     * @return conversaciones del usuario
     */
    public static ArrayList<Conversacion> getConversacionesUsuarioLogeado(User user){
        return ConversacionDAO.getConversacionesByUserFromDB(user);
    }

    /**
     * Carga los mensajes de todas las conversaciones del usuario logeado
     * @param conversaciones
     * @return true siempre
     */
    public static boolean getMesajesForUserConversations(ArrayList<Conversacion> conversaciones){
        for (Conversacion conversacion : conversaciones) {
            conversacion.setMensajes(MensajeDAO.getMensajesFromDB(conversacion.getCodigoConversacion()));
        }
        return true;
    }
}
