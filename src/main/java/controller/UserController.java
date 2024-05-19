package controller;

import model.User;
import model.UserModel;
import model.dao.DatabaseConnection;
import model.dao.UserDAO;
import view.LoginWindow;
import view.MainWindow;
import view.RegisterWindow;

import java.sql.*;

import static model.UserModel.users;

public class UserController {
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
        openLoginWindow();
    }

    /**
     * Comprueba si un usuario puede logearse en la aplicación.
     *
     * @param userName el nombre de usuario del usuario
     * @param password la contraseña del usuario
     */
    public static void comprobarlogin(String userName, String password){
        if(UserModel.loggin(userName, password)){
            System.out.println("Usuario logeado");
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

}
