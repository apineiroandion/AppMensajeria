package interfazUsuario.resources;

import javax.swing.*;
import java.awt.*;

public class CuadroDeTexto extends JTextField{

    public CuadroDeTexto(int ancho, int alto) {
        setSize(ancho, alto);
        setFont(new Font("Arial", 0, 15));
        setForeground(new Color(175, 175, 175));
        setBackground(new Color(40, 40, 40));
    }
}
