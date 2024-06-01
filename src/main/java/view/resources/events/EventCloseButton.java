package view.resources.events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Evento de boton para cerrar una ventana
 */
public class EventCloseButton implements ActionListener {
    JButton closeButton;
    public EventCloseButton(JButton closeButton) {
        this.closeButton = closeButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // cerrar ventana
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(closeButton);
        frame.dispose();
    }
}
