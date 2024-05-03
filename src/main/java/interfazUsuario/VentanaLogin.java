package interfazUsuario;

import interfazUsuario.resources.CuadroDeTexto;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private CuadroDeTexto cuadroDeTexto;
    //TODO: Añadir cuadros de texto y botones en la ventana
    public VentanaLogin() {

        // Mostrar todos los componentes de la ventana
        createAndShowGUI();

        setSize(500, 400);
        setLayout(null);
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

        JTextField pwtxt = new CuadroDeTexto(10, 10);
        pwtxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        pwtxt.setBounds(75, 200, 350, 40);

        this.add(usernametxt);
        this.add(pwtxt);

    }
}