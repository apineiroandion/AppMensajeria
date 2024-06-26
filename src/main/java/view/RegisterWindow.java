package view;

import controller.UserController;
import view.resources.*;
import view.resources.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Frame ventana registro
 */
public class RegisterWindow extends JFrame {
    private Point initialClick;
    // Textfields
    GenericTextField userName;
    GenericTextField firstName;
    GenericTextField surName;
    GenericPasswordFIeld password;
    public RegisterWindow() {
        // Mostrar todos los textfields del frame
        crearTextFields();
        // Mostrar todos los labels del frame
        crearLabels();
        // Mostrar todos los buttons del frame
        crearButtons();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Localización de la ventana
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determinar cuánto se ha movido el ratón desde el click inicial
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Mover la ventana a la nueva posición
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });

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

    /**
     * Iniciar todos los textfields del Jframe
     */
    private void crearTextFields() {
        // JTextField nombre usuario
        userName = new GenericTextField(250, 40, Color.BLACK);
        userName.setLocation(50, 100);
        add(userName);

        // JTextField nombre
        firstName = new GenericTextField(250, 40, Color.BLACK);
        firstName.setLocation(50,175);
        add(firstName);

        // JTextField apellido
        surName = new GenericTextField(250,40, Color.BLACK);
        surName.setLocation(50,250);
        add(surName);

        // JTextField contraseña
        password = new GenericPasswordFIeld(250,40, Color.BLACK);
        password.setLocation(50,325);
        add(password);
    }

    /**
     * Iniciar todos los labels del Jframe
     */
    private void crearLabels() {
        // JLabel titulo
        JLabel title = new Label("Registro", 40);
        title.setBounds(100, 20, 250, 50);
        add(title);

        // Jlabel nombre usuario
        JLabel userNamelbl = new Label("Usuario",15);
        userNamelbl.setBounds(50,70,100,40);
        add(userNamelbl);

        // JLabel nombre
        JLabel firstNamelbl = new Label("Nombre",15);
        firstNamelbl.setBounds(50,145,100,40);
        add(firstNamelbl);

        // JLabel apellido
        JLabel surNamelbl = new Label("Apellido",15);
        surNamelbl.setBounds(50,220,100,40);
        add(surNamelbl);

        // JLabel contraseña
        JLabel passwordlbl = new Label("Contraseña",15);
        passwordlbl.setBounds(50,295,100,40);
        add(passwordlbl);

        JLabel loginlbl = new Label("Ya tienes una cuenta? Inicia sesion",15);
        loginlbl.setBounds(50, 450, 250, 40);
        this.add(loginlbl);
    }

    /**
     * Iniciar todos los buttons del Jframe
     */
    private void crearButtons() {
        // JButton registrarse
        JButton registerbtn = new GenericButton("Registrarse");
        registerbtn.setBounds(75, 380, 200, 60);
        add(registerbtn);

        //  Add Listener
        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bloquear el registro si algún campo está vacío
                if (userName.getText().trim().isEmpty()||firstName.getText().trim().isEmpty()||surName.getText().trim().isEmpty()||password.getText().trim().isEmpty()){
                    System.out.println("Faltan campos por rellenar");
                    return;
                }

                UserController.comprobarRegistro(userName.getText(), firstName.getText(), surName.getText(), password.getText());
                dispose();
            }
        });

        // JButton cerrar
        JButton closebtn = new CloseButton();
        closebtn.setBounds(315,0,35,35);
        this.add(closebtn);
    }
}
