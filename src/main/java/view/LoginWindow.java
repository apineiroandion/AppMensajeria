package view;

import view.resources.Button;
import view.resources.GenericTextField;
import view.resources.Etiqueta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Frame ventana Login
 */
public class LoginWindow extends JFrame {
    private Point initialClick;
    public LoginWindow() {

        // Mostrar todos los componentes de la ventana
        createAndShowGUI();

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
     * Iniciar todos los componentes del JFrame
     */
    private void createAndShowGUI() {
        // JTextField nombre usuario
        JTextField usernametxt = new GenericTextField(10, 10, Color.black);
        usernametxt.setBounds(75, 100, 350, 40);
        this.add(usernametxt);
        // JTextField contraseña
        JTextField pwtxt = new GenericTextField(10, 10, Color.black);
        pwtxt.setBounds(75, 200, 350, 40);
        this.add(pwtxt);
        // JLabel usuario
        JLabel usernamelbl = new Etiqueta("Usuario",20);
        usernamelbl.setBounds(75, 65, 100, 40);
        this.add(usernamelbl);
        // JLabel contraseña
        JLabel pwlbl = new Etiqueta("Contraseña",20);
        pwlbl.setBounds(75, 165, 500, 40);
        this.add(pwlbl);
        // JButton iniciar sesion
        JButton loginbtn = new Button("Iniciar Sesión");
        loginbtn.setBounds(325, 250, 100, 40);
        this.add(loginbtn);
        // JLabel registro
        JLabel register = new Etiqueta("Registrarse",15, "http://google.com");
        register.setBounds(75, 250, 100, 40);
        register.setForeground(new java.awt.Color(54, 54, 255));
        this.add(register);
        // JButton terminar proceso
        JButton closebtn = new Button("X");
        closebtn.setBounds(465,0,35,35);
        closebtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closebtn.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closebtn.setBackground(new java.awt.Color(40, 40, 40));
            }
        });
        closebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(closebtn);
    }
}