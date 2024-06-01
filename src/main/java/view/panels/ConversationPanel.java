package view.panels;

import view.MainWindow;
import view.resources.Label;
import view.resources.events.EventSwitchConversation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel de conversaciones
 */
public class ConversationPanel extends JPanel {
    private ConversationListPanel parentPanel; // Panel superior
    /**
     * Constructor
     * @param usuario Nombre de usuario
     * @param parentPanel Panel superior
     * @param ID ID de la conversación
     */
    public ConversationPanel(String usuario, ConversationListPanel parentPanel, int ID) {
        this.parentPanel = parentPanel;
        setPreferredSize(new Dimension(250,50));
        setMaximumSize(new Dimension(250,50));
        setBackground(new Color(50,50,50));
        setLayout(new BorderLayout());

        Label lbl = new Label(usuario,15);
        lbl.setBorder(new EmptyBorder(0, 10, 0, 0)); // Añade un borde vacío a la izquierda de la etiqueta
        this.add(lbl, BorderLayout.WEST);

        // Añadir MouseListener
        this.addMouseListener(new EventSwitchConversation(usuario, ID, this, parentPanel));
    }


}
