package view;

import controller.UserController;
import view.resources.*;
import view.resources.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Frame ventana Login
 */
public class LoginWindow extends JFrame {
    private Point initialClick;
    private GenericTextField usernametxt;
    private GenericPasswordFIeld pwtxt;

    public LoginWindow() {

        // Mostrar todos los buttons del frame
        crearBotones();
        // Mostrar todos los labels del frame
        crearLabels();
        // Mostrar todos los textfields del frame
        crearTextFields();

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

        setSize(500, 350);
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
     * Iniciar todos los buttons del JFrame
     */
    private void crearBotones() {
        // JButton iniciar sesion
        JButton loginbtn = new GenericButton("Iniciar Sesión");
        loginbtn.setBounds(325, 250, 100, 40);
        this.add(loginbtn);

        // JButton terminar proceso
        JButton closebtn = new CloseButton();
        closebtn.setBounds(465,0,35,35);
        this.add(closebtn);

        /**
         * Acción de los botones
         */
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController.comprobarlogin(usernametxt.getText(), pwtxt.getText());
            }
        });
    }
    /**
     * Iniciar todos los labels del JFrame
     */
    private void crearLabels() {
        // JLabel usuario
        JLabel usernamelbl = new Label("Usuario",20);
        usernamelbl.setBounds(75, 65, 100, 40);
        this.add(usernamelbl);

        // JLabel contraseña
        JLabel pwlbl = new Label("Contraseña",20);
        pwlbl.setBounds(75, 165, 500, 40);
        this.add(pwlbl);

        // JLabel registro
        JLabel register = new Label("Registrarse",15);
        register.setBounds(75, 250, 100, 40);
        this.add(register);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserController.openRegisterWindow();
            }
        });
    }
    /**
     * Iniciar todos los textfields del JFrame
     */
    private void crearTextFields() {
        // JTextField nombre usuario
        usernametxt = new GenericTextField(350, 40, Color.black);
        usernametxt.setLocation(75,100);
        this.add(usernametxt);

        // JPasswordField contraseña
        pwtxt = new GenericPasswordFIeld(350, 40, Color.black);
        pwtxt.setLocation(75,200);
        this.add(pwtxt);
    }

}