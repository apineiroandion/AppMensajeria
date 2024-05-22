package view.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Panel de lista de conversaciones
 */
public class ConversationListPanel extends JPanel {
    private ConversationPanel conversationPanel;
    public ConversationListPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50,50,50));
    }

    public void addConversation(String usuario) {
        ConversationPanel conversationPanel = new ConversationPanel(usuario);
        this.add(conversationPanel);

    }
}
