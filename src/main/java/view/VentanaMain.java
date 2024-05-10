package view;

import view.resources.Etiqueta;

import javax.swing.*;
import java.awt.*;

public class VentanaMain extends JFrame {
    final int LEFT_PANEL_WIDTH = 250;
    public VentanaMain() {
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
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, 600));
        leftPanel.setBackground(new Color(50, 50, 50));
        this.add(leftPanel, BorderLayout.WEST);

        /**
         * bottomLeftPanel GridBagLayout
         */
        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setLayout(new GridBagLayout());
        bottomLeftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH,100));
        bottomLeftPanel.setBackground(new Color(40,40,40));
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        JLabel userNamelbl = new Etiqueta("UserName",15);
        bottomLeftPanel.add(userNamelbl);
    }
}
