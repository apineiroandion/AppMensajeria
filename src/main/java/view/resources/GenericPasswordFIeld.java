package view.resources;

import view.resources.events.EventColor;

import javax.swing.*;
import java.awt.*;

public class GenericPasswordFIeld extends JPasswordField {
    public GenericPasswordFIeld(int ancho, int alto, Color borderColor) {
        setSize(ancho, alto);
        setEchoChar('*');
        setFont(new Font("Arial", 0, 15));
        setBorder(BorderFactory.createLineBorder(borderColor, 2));
        setForeground(new Color(175, 175, 175));
        setBackground(new Color(40, 40, 40));
        addFocusListener(new EventColor(this, borderColor, Color.white));
    }
}
