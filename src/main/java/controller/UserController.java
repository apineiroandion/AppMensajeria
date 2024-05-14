package controller;

import model.User;
import model.UserModel;
import view.LoginWindow;
import view.RegisterWindow;

import static model.UserModel.users;

public class UserController {
    public static void iniciarApp(){
        System.out.println("Iniciando la aplicación...");

        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);

        User user1 = new User("user1", "User", "One", "password");
        users.add(user1);
        /*
        RegisterWindow registerWindow = new RegisterWindow();
        registerWindow.setVisible(true);
         */
    }

    public static void comprobarlogin(String userName, String password){
        if(UserModel.loggin(userName, password)){
            System.out.println("Usuario logeado");
        }else{
            System.out.println("Usuario no logeado");
        }
    }
}
