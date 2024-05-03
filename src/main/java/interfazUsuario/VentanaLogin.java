package interfazUsuario;

import interfazUsuario.resources.Boton;
import interfazUsuario.resources.CuadroDeTexto;
import interfazUsuario.resources.Etiqueta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JFrame {
    private CuadroDeTexto cuadroDeTexto;
    private Point initialClick;
    //TODO: Añadir cuadros de texto y botones en la ventana
    public VentanaLogin() {

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

    private void createAndShowGUI() {
        JTextField usernametxt = new CuadroDeTexto(10, 10);
        usernametxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        usernametxt.setBounds(75, 100, 350, 40);
        this.add(usernametxt);

        JTextField pwtxt = new CuadroDeTexto(10, 10);
        pwtxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        pwtxt.setBounds(75, 200, 350, 40);
        this.add(pwtxt);

        JLabel usernamelbl = new Etiqueta("Usuario");
        usernamelbl.setBounds(75, 65, 100, 40);
        this.add(usernamelbl);

        JLabel pwlbl = new Etiqueta("Contraseña");
        pwlbl.setBounds(75, 165, 500, 40);
        this.add(pwlbl);

        JButton loginbtn = new Boton("Iniciar Sesión");
        loginbtn.setBounds(325, 250, 100, 40);
        this.add(loginbtn);

        JButton closebtn = new Boton("X");
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
        this.add(closebtn);
    }
}