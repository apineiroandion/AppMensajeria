package view;

import view.panels.BottomLeftPanel;
import view.panels.RightChatPanel;
import view.panels.LeftPanel;
import view.resources.Label;

import javax.swing.*;
import java.awt.*;

/**
 * Frame ventana principal
 */
public class MainWindow extends JFrame {
    private LeftPanel leftPanel;
    private BottomLeftPanel bottomLeftPanel;
    private RightChatPanel rightChatPanel;
    private Label userNamelbl;

    public MainWindow() {
        setLayout(new BorderLayout());
        // Mostrar todos los panels del frame
        crearPanels();
        // Mostrar todos los labels del frame
        crearLabels();
        setSize(800, 600);
        setTitle("Chats");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Iniciar todos los panels del JFrame
     */
    private void crearPanels() {
        /**
         * leftPanel BorderLayout
         */
        leftPanel = new LeftPanel();
        this.add(leftPanel, BorderLayout.WEST);

        /**
         * bottomLeftPanel GridBagLayout
         */
        bottomLeftPanel = new BottomLeftPanel();
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        /**
         * rightChatPanel BorderLayout
         */
        rightChatPanel = new RightChatPanel();
        add(rightChatPanel, BorderLayout.CENTER);
    }
    /**
     * Iniciar todos los labels del JFrame
     */
    private void crearLabels(){
        userNamelbl = new Label("UserName",15);
        bottomLeftPanel.add(userNamelbl);
    }
}
