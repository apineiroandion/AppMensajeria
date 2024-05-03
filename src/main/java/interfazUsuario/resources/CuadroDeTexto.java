package interfazUsuario.resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CuadroDeTexto extends JTextField{

    public CuadroDeTexto(int ancho, int alto) {
        setSize(ancho, alto);
        setFont(new Font("Arial", 0, 15));
        setForeground(new Color(175, 175, 175));
        setBackground(new Color(40, 40, 40));
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.white, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.black, 2));
            }
        });
    }
}
