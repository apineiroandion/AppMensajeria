package view.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Panel en la parte superior derecha de la ventana principal que contiene el
 * nombre de usuario del destinatario.
 */
public class TopRightPanel extends JPanel {
    public TopRightPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(this.getWidth(), 50));
    }
}
