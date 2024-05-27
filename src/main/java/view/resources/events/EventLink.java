package view.resources.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
/**
 * Esta clase abre un enlace en el navegador predeterminado cuando pulsamos el label
 */
public class EventLink extends MouseAdapter {
    JLabel etiqueta;
    String url;

    /**
     *
     * @param etiqueta que se utilizará
     * @param url que se abrirá
     */
    public EventLink(JLabel etiqueta, String url) {
        this.etiqueta = etiqueta;
        this.url = url;
    }

    /**
     * Evento click
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
