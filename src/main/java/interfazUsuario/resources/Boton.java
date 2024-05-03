package interfazUsuario.resources;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    public Boton(String texto) {
        super(texto);
        setFont(new java.awt.Font("Arial", 0, 15));
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(40, 40, 40));
        setMargin(new Insets(0, 0, 0, 0));
        setFocusPainted(false);
        setBorderPainted(false);
    }
}
