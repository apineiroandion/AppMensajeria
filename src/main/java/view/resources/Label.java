package view.resources;

import view.resources.events.EventLink;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    /**
     * Etiqueta de texto normal
     * @param texto String del contenido
     * @param tamanoFuente tamaño del texto
     */
    public Label(String texto, int tamanoFuente) {
        super(texto);
        setFont(new java.awt.Font("Arial", Font.PLAIN, tamanoFuente));
        setForeground(new java.awt.Color(255, 255, 255));
    }

    /**
     * Etiqueta de texto con enlace
     * @param texto String del contenido
     * @param tamanoFuente tamaño del texto
     * @param url url del enlace
     */
    public Label(String texto, int tamanoFuente, String url) {
        super(texto);
        setFont(new java.awt.Font("Arial", Font.PLAIN, tamanoFuente));
        setForeground(new java.awt.Color(255, 255, 255));
        addMouseListener(new EventLink(this,url));
    }
}
