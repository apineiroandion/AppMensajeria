package view.panels;

import javax.swing.*;
import java.awt.*;

public class MessageListPanel extends JPanel {
    public MessageListPanel(boolean isSent) {
        setLayout(new FlowLayout(isSent ? FlowLayout.RIGHT : FlowLayout.LEFT));
        setBackground(new Color(45,45,45));
    }
}
