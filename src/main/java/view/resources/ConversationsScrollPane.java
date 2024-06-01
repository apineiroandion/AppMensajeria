package view.resources;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ConversationsScrollPane extends JScrollPane {
    /**
     * ScrollPane de las conversaciones
     */
    public ConversationsScrollPane() {
        setBackground(new Color(50,50,50));
        getViewport().setBackground(new Color(50,50,50));   // Color fondo
        setBorder(createEmptyBorder()); // Eliminar borde

        // Aplicar la UI personalizada al scrollbar
        getVerticalScrollBar().setUI(new ScrollBarUI());
    }
}
