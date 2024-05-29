package view.panels;

import javax.swing.*;
import java.awt.*;
/**
 * Panel izquierdo de la ventana principal.
 */
public class LeftPanel extends JPanel {
    public LeftPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, 600));
        setBackground(new Color(50, 50, 50));
    }
}
