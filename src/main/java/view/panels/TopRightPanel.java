package view.panels;

import javax.swing.*;
import java.awt.*;

public class TopRightPanel extends JPanel {
    public TopRightPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(this.getWidth(), 50));
    }
}
