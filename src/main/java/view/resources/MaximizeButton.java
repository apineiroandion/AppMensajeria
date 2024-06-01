package view.resources;

import javax.swing.*;
import java.awt.*;

public class MaximizeButton extends JButton {
    public MaximizeButton() {
        setText("□");
        setFont(new java.awt.Font("Arial", Font.PLAIN, 15));
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(40, 40, 40));
        setMargin(new Insets(0, 0, 0, 0));
        setPreferredSize(new Dimension(40, 25));
        setFocusPainted(false);
        setBorderPainted(false);

        // maximizar o restaurar la ventana al hacer click
        addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                frame.setExtendedState(JFrame.NORMAL);
            } else {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}
