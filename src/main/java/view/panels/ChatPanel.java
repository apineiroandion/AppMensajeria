package view.panels;

import view.resources.MessageTextArea;

import javax.swing.*;
import java.awt.*;

/**
 * Panel de chat
 */
public class ChatPanel extends JPanel {
    private Box.Filler filler;
    public ChatPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(45,45,45));
        // Filler para rellenar el espacio inferior vacío
        filler = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    public void addMessage(String message, boolean isSent, JScrollPane chatScrollPane) {
        JPanel messageListPanel = new MessageListPanel(isSent);

        int messageLength = message.length();
        if (messageLength >= 25) {
            messageLength = 25;
        }

        // JTextArea con el contenido del mensaje
        JTextArea messageTextArea = new MessageTextArea(message, messageLength, isSent);

        // Crear un JPanel personalizado para la burbuja de chat
        JPanel bubblePanel = new BubblePanel(isSent);

        // Añade el label al panel de la burbuja
        bubblePanel.add(messageTextArea, BorderLayout.CENTER);

        // Añade la burbuja al panel de mensajes
        messageListPanel.add(bubblePanel);
        // Añade el panel de mensajes al panel de chat
        this.add(messageListPanel);

        // Borra y añade el filler para actualizar su tamaño
        this.remove(filler);
        this.add(filler);

        this.revalidate();

        // Desplaza el ChatScrollPane hacia abajo
        SwingUtilities.invokeLater(() -> { // Usar invokeLater para que se ejecute después de que se haya añadido el mensaje
            JScrollBar verticalScrollBar = chatScrollPane.getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getMaximum());
        });
    }
}
