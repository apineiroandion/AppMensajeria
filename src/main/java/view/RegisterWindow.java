package view;

import view.resources.*;
import view.resources.Label;

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

        // JLabel titulo
        JLabel title = new Label("Registro", 40);
        title.setBounds(100, 20, 250, 50);
        add(title);

        // JTextField nombre usuario
        JTextField userName = new GenericTextField(250, 40, Color.BLACK);
        userName.setLocation(50, 100);
        add(userName);
        // Jlabel nombre usuario
        JLabel userNamelbl = new Label("Usuario",15);
        userNamelbl.setBounds(50,70,100,40);
        add(userNamelbl);

        // JTextField nombre
        JTextField firstName = new GenericTextField(250, 40, Color.BLACK);
        firstName.setLocation(50,175);
        add(firstName);
        // JLabel nombre
        JLabel firstNamelbl = new Label("Nombre",15);
        firstNamelbl.setBounds(50,145,100,40);
        add(firstNamelbl);

        // JTextField apellido
        JTextField surName = new GenericTextField(250,40, Color.BLACK);
        surName.setLocation(50,250);
        add(surName);
        // JLabel apellido
        JLabel surNamelbl = new Label("Apellido",15);
        surNamelbl.setBounds(50,220,100,40);
        add(surNamelbl);

        // JTextField contraseña
        JTextField password = new GenericPasswordFIeld(250,40, Color.BLACK);
        password.setLocation(50,325);
        add(password);
        // JLabel contraseña
        JLabel passwordlbl = new Label("Contraseña",15);
        passwordlbl.setBounds(50,295,100,40);
        add(passwordlbl);

        // JButton registrarse
        JButton registerbtn = new GenericButton("Registrarse");
        registerbtn.setBounds(75, 400, 200, 60);
        add(registerbtn);

        // JButton cerrar
        JButton closebtn = new CloseButton();
        closebtn.setBounds(315,0,35,35);
        this.add(closebtn);

    }
}
