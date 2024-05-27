package view.resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Área de texto para los mensajes
 */
public class MessageTextArea extends JTextArea {
    /**
     *
     * @param message texto del mensaje
     * @param messageLength longitud del mensaje
     * @param isSent si el mensaje es enviado o recibido
     */
    public MessageTextArea(String message, int messageLength, boolean isSent) {
        super(message);
        setWrapStyleWord(true);
        setLineWrap(true);
        setColumns(messageLength);
        setFont(new Font("Arial", Font.PLAIN, 20));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(isSent ? new Color(50, 50, 50) : new Color(75, 75, 75));
        setForeground(Color.WHITE);
        setEditable(false);
    }
}
