package interfazUsuario.resources;

import javax.swing.*;

public class Etiqueta extends JLabel {
    public Etiqueta(String texto) {
        super(texto);
        setFont(new java.awt.Font("Arial", 0, 20));
        setForeground(new java.awt.Color(255, 255, 255));
    }
}
