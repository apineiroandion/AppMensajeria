package view.panels;

import view.resources.RoundedBorder;

import javax.swing.*;
import java.awt.*;
/**
 * Panel de burbuja de chat
 */
public class BubblePanel extends JPanel {
    public BubblePanel(boolean isSent) {
        setLayout(new BorderLayout());
        setBackground(isSent ? new Color(50, 50, 50) : new Color(75, 75, 75)); // Color de la burbuja
        setBorder(new RoundedBorder(Color.BLACK, 1, 10));
    }

}
