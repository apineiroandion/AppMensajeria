package view.panels;

import javax.swing.*;
import java.awt.*;
/**
 * Panel en la parte inferior izquierda de la ventana principal.
 */
public class BottomLeftPanel extends JPanel {
    public BottomLeftPanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(250,100));
        setBackground(new Color(40,40,40));
    }
}
