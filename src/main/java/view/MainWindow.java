package view;

import view.panels.*;
import view.resources.GenericButton;
import view.resources.GenericTextField;
import view.resources.Label;

import javax.swing.*;
import java.awt.*;

/**
 * Frame ventana principal
 */
public class MainWindow extends JFrame {
    // Paneles
    private LeftPanel leftPanel;
    private BottomLeftPanel bottomLeftPanel;
    private RightPanel rightPanel;
    private TopRightPanel topRightPanel;
    private BottomRightPanel bottomRightPanel;
    private GridBagConstraints gbcrightBottomPanel;

    // Labels
    private Label userNamelbl;

    // TextFields
    private GenericTextField chatmsg;

    // Buttons
    private GenericButton sendButton;

    public MainWindow() {
        setLayout(new BorderLayout());
        // Mostrar todos los panels del frame
        crearPanels();
        // Mostrar todos los labels del frame
        crearLabels();
        // Mostrar todos los textfields del frame
        crearTextFields();
        // Mostrar todos los buttons del frame
        crearButtons();
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
         * rightPanel BorderLayout
         */
        rightPanel = new RightPanel();
        add(rightPanel, BorderLayout.CENTER);

        /**
         * topRightPanel GridBagLayout
         */
        topRightPanel = new TopRightPanel();
        rightPanel.add(topRightPanel, BorderLayout.NORTH);

        /**
         * bottomRightPanel GridBagLayout
         */
        bottomRightPanel = new BottomRightPanel();
        rightPanel.add(bottomRightPanel, BorderLayout.SOUTH);
    }
    /**
     * Iniciar todos los labels del JFrame
     */
    private void crearLabels(){
        // Label UserName
        userNamelbl = new Label("UserName",15);
        bottomLeftPanel.add(userNamelbl);
    }
    /**
     * Iniciar todos los textfields del JFrame
     */
    private void crearTextFields() {
        // JTextField chatmsg
        chatmsg = new GenericTextField(100,50,Color.BLACK);
        chatmsg.setPreferredSize(new Dimension(chatmsg.getWidth(), 50));
        gbcrightBottomPanel = new GridBagConstraints();
        gbcrightBottomPanel.gridx = 0;
        gbcrightBottomPanel.gridy = 0;
        gbcrightBottomPanel.weightx = 0.8;
        gbcrightBottomPanel.weighty = 1;
        gbcrightBottomPanel.fill = GridBagConstraints.BOTH;
        bottomRightPanel.add(chatmsg,gbcrightBottomPanel);
    }
    /**
     * Iniciar todos los buttons del JFrame
     */
    private void crearButtons() {
        // JButton enviar
        sendButton = new GenericButton("Enviar");
        sendButton.setPreferredSize(new Dimension(sendButton.getWidth(),50));
        gbcrightBottomPanel.gridx = 1;
        gbcrightBottomPanel.gridy = 0;
        gbcrightBottomPanel.weightx = 0.2;
        gbcrightBottomPanel.weighty = 1;
        gbcrightBottomPanel.fill = GridBagConstraints.BOTH;
        bottomRightPanel.add(sendButton,gbcrightBottomPanel);
    }
}
