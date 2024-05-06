package interfazUsuario.resources;

import interfazUsuario.resources.eventos.EventoColor;

import javax.swing.*;
import java.awt.*;

public class CuadroDeTexto extends JTextField{
    /**
     * Cuadro de texto
     * @param ancho ancho del JTextField
     * @param alto alto del JTextField
     */
    public CuadroDeTexto(int ancho, int alto) {
        setSize(ancho, alto);
        setFont(new Font("Arial", 0, 15));
        setForeground(new Color(175, 175, 175));
        setBackground(new Color(40, 40, 40));
        addFocusListener(new EventoColor(this, Color.BLACK, Color.white));
    }
}
