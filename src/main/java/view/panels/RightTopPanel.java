package view.panels;

import javax.swing.*;
import java.awt.*;

public class RightTopPanel extends JPanel {
    public RightTopPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(this.getWidth(), 50));
    }
}
