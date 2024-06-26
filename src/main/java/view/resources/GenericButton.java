package view.resources;

import javax.swing.*;
import java.awt.*;

public class GenericButton extends JButton {
    /**
     * Boton normal
     * @param texto del boton
     */
    public GenericButton(String texto) {
        super(texto);
        setFont(new java.awt.Font("Arial", Font.PLAIN, 15));
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(40, 40, 40));
        setMargin(new Insets(0, 0, 0, 0));
        setFocusPainted(false);
        setBorderPainted(false);
    }
}
