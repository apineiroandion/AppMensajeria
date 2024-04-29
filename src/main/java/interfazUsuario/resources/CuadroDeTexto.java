package interfazUsuario.resources;

import javax.swing.*;
import java.awt.*;

public class CuadroDeTexto extends JTextField{

    public CuadroDeTexto(int ancho, int alto) {
        setSize(ancho, alto);
        setForeground(new Color(255, 255, 255));
        setBackground(new Color(40, 40, 40));
    }
}
