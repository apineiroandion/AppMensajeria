package view.resources;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ChatScrollPane extends JScrollPane {
    /**
     * ScrollPane del chat
     */
    public ChatScrollPane() {
        setBackground(new Color(45,45,45));
        getViewport().setBackground(new Color(45,45,45));   // Color fondo
        setBorder(createEmptyBorder()); // Eliminar borde
    }
}
