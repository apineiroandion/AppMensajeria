package view.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel de lista de conversaciones
 */
public class ConversationListPanel extends JPanel {
    private List<ConversationPanel> conversationPanels;
    public ConversationListPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50,50,50));
        conversationPanels = new ArrayList<>();
    }

    /**
     * Añade una conversación al panel
     * @param usuario Nombre de usuario del chat
     */
    public void addConversation(String usuario, int ID) {
        ConversationPanel conversationPanel = new ConversationPanel(usuario, this, ID);
        this.add(conversationPanel);
        conversationPanels.add(conversationPanel);
    }

    /**
     * Cambia el color de los otros paneles de conversación
     * @param currentPanel Panel seleccionado
     */
    public void changeColorOthers(ConversationPanel currentPanel) {
        for (ConversationPanel panel : conversationPanels) {
            if (panel != currentPanel) {
                panel.setBackground(new Color(50,50,50));
            }
        }
    }
}
