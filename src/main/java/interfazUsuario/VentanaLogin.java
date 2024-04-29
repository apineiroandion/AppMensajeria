package interfazUsuario;

import interfazUsuario.resources.CuadroDeTexto;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private CuadroDeTexto cuadroDeTexto;
    //TODO: Añadir cuadros de texto y botones en la ventana
    public VentanaLogin() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        JTextField login = new CuadroDeTexto(10, 10);
        panel.add(login);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        add(panel);
        //getContentPane().setBackground(new java.awt.Color(30, 30, 30));
        setVisible(true);
    }

}