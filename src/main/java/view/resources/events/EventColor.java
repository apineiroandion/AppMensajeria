package view.resources.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Esta clase cambia el color de borde del JTextField cuando se selecciona y se deselecciona
 */
public class EventColor extends FocusAdapter {
    JTextField cuadroDeTexto;
    Color colorBase;
    Color colorHover;

    /**
     *
     * @param cuadroDeTexto JTextField que se utilizará
     * @param colorBase Color borde no seleccionado
     * @param colorHover Color borde seleccionado
     */
    public EventColor(JTextField cuadroDeTexto, Color colorBase, Color colorHover) {
        this.cuadroDeTexto = cuadroDeTexto;
        this.colorBase = colorBase;
        this.colorHover = colorHover;
    }

    /**
     * Evento JTextField seleccionado
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        cuadroDeTexto.setBorder(BorderFactory.createLineBorder(colorHover, 2));
    }

    /**
     * Evento JTextField no seleccionado
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {
        cuadroDeTexto.setBorder(BorderFactory.createLineBorder(colorBase, 2));
    }
}
