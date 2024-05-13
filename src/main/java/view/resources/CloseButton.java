package view.resources;

import view.resources.events.EventCloseButton;
import view.resources.events.EventMouseListenerCloseButton;

import javax.swing.*;
import java.awt.*;

public class CloseButton extends JButton {
    /**
     * Botón cerrar
     */
    public CloseButton() {
        setText("X");
        setFont(new java.awt.Font("Arial", Font.PLAIN, 15));
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(40, 40, 40));
        setMargin(new Insets(0, 0, 0, 0));
        setFocusPainted(false);
        setBorderPainted(false);
        addMouseListener(new EventMouseListenerCloseButton(this));
        addActionListener(new EventCloseButton(this));
    }
}
