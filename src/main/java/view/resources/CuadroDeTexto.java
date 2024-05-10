package view.resources;

import view.resources.eventos.EventoColor;

import javax.swing.*;
import java.awt.*;

public class CuadroDeTexto extends JTextField{
    /**
     * Cuadro de texto con borderColor que cambia de color al seleccionarlo
     * @param ancho ancho del JTextField
     * @param alto alto del JTextField
     * @param borderColor color del borde
     */
    public CuadroDeTexto(int ancho, int alto, Color borderColor) {
        setSize(ancho, alto);
        setFont(new Font("Arial", 0, 15));
        setBorder(BorderFactory.createLineBorder(borderColor, 2));
        setForeground(new Color(175, 175, 175));
        setBackground(new Color(40, 40, 40));
        addFocusListener(new EventoColor(this, borderColor, Color.white));
    }

    /**
     * Cuadro de texto sin borderColor
     * @param ancho ancho del JTextField
     * @param alto alto del JTextField
     */
    public CuadroDeTexto(int ancho, int alto) {
        setSize(ancho, alto);
        setFont(new Font("Arial", 0, 15));
        setForeground(new Color(175, 175, 175));
        setBackground(new Color(40, 40, 40));
    }
}
