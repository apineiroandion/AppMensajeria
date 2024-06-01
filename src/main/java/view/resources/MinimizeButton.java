package view.resources;

import javax.swing.*;
import java.awt.*;

public class MinimizeButton extends JButton {
    public MinimizeButton() {
        setText("-");
        setFont(new java.awt.Font("Arial", Font.PLAIN, 15));
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(40, 40, 40));
        setMargin(new Insets(0, 0, 0, 0));
        setPreferredSize(new Dimension(40, 25));
        setFocusPainted(false);
        setBorderPainted(false);

        // minimizar la ventana al hacer click
        addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.setExtendedState(JFrame.ICONIFIED);
        });
    }
}
