package view.panels;

import javax.swing.*;
import java.awt.*;
/**
 * Panel de lista de mensajes
 */
public class MessageListPanel extends JPanel {
    /**
     * Constructor de la clase
     * @param isSent Indica si el mensaje fue enviado o recibido
     */
    public MessageListPanel(boolean isSent) {
        setLayout(new FlowLayout(isSent ? FlowLayout.RIGHT : FlowLayout.LEFT));
        setBackground(new Color(45,45,45));
    }
}
