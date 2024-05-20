package view.panels;

import view.resources.Label;
import view.resources.RoundedBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    public void addMessage(String message, boolean isSent) {
        JPanel messageListPanel = new MessageListPanel(isSent);

        // Label con el contenido del mensaje
        Label messageLabel = new Label(message,20);
        messageLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Crear un JPanel personalizado para la burbuja de chat
        JPanel bubblePanel = new BubblePanel(isSent);

        // Añade el label al panel de la burbuja
        bubblePanel.add(messageLabel, BorderLayout.CENTER);

        // Añade la burbuja al panel de mensajes
        messageListPanel.add(bubblePanel);
        // Añade el panel de mensajes al panel de chat
        this.add(messageListPanel);

        // Borra y añade el filler para actualizar su tamaño
        this.remove(filler);
        this.add(filler);

        this.revalidate();
    }
}