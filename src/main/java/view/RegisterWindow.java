package view;

import view.resources.Label;
import view.resources.GenericTextField;

import javax.swing.*;
import java.awt.*;

public class RegisterWindow extends JFrame {
    public RegisterWindow() {

        createAndShowGUI();

        setSize(350, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Iniciar Sesión");
        getContentPane().setBackground(new java.awt.Color(50, 50, 50));
        setVisible(true);
    }

    private void createAndShowGUI() {
        // JTextField nombre usuario
        JTextField userName = new GenericTextField(250, 40, Color.BLACK);
        userName.setLocation(50, 100);
        add(userName);

        JLabel userNamelbl = new Label("Usuario",20);
        userNamelbl.setLocation(50,80);
        add(userNamelbl);
        // JTextField nombre
        JTextField firstName = new GenericTextField(250, 40, Color.BLACK);
        firstName.setLocation(50,175);
        add(firstName);
        // JTextField apellido
        JTextField surName = new GenericTextField(250,40, Color.BLACK);
        surName.setLocation(50,250);
        add(surName);
        // JTextField contraseña
        JTextField password = new GenericTextField(250,40, Color.BLACK);
        password.setLocation(50,325);
        add(password);


    }
}
