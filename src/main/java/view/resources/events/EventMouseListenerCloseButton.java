package view.resources.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Cambiar color boton cerrar cuando se le pasa el raton por encima
 */
public class EventMouseListenerCloseButton extends MouseAdapter {
    JButton closeButton;

    /**
     *
     * @param closeButton boton cerrar
     */
    public EventMouseListenerCloseButton(JButton closeButton) {
        this.closeButton = closeButton;
    }

    /**
     * poner raton encima
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        closeButton.setBackground(Color.RED);
    }

    /**
     * quitar raton de encima
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
        closeButton.setBackground(new java.awt.Color(40, 40, 40));
    }
}
