package view.panels;

import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConversationPanel extends JPanel {
    public ConversationPanel(String usuario) {
        setPreferredSize(new Dimension(250,50));
        setMaximumSize(new Dimension(250,50));
        setBackground(new Color(50,50,50));
        setLayout(new BorderLayout());
        Label lbl = new Label(usuario,15);
        lbl.setBorder(new EmptyBorder(0, 10, 0, 0)); // Añade un borde vacío a la izquierda de la etiqueta
        this.add(lbl, BorderLayout.WEST);
    }
}
