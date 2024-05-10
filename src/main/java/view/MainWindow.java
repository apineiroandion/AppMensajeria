package view;

import view.panels.BottomLeftPanel;
import view.panels.RightChatPanel;
import view.panels.LeftPanel;
import view.resources.Etiqueta;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setSize(800, 600);
        setTitle("Chats");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        createAndShowGUI();
        setVisible(true);
    }
    private void createAndShowGUI() {
        // Crear y mostrar todos los componentes de la ventana

        /**
         * leftPanel BorderLayout
         */
        JPanel leftPanel = new LeftPanel();
        this.add(leftPanel, BorderLayout.WEST);

        /**
         * bottomLeftPanel GridBagLayout
         */
        JPanel bottomLeftPanel = new BottomLeftPanel();
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        JLabel userNamelbl = new Etiqueta("UserName",15);
        bottomLeftPanel.add(userNamelbl);

        /**
         * rightChatPanel BorderLayout
         */
        JPanel rightChatPanel = new RightChatPanel();
        add(rightChatPanel, BorderLayout.CENTER);
    }
}
