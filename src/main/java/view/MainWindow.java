package view;

import view.panels.*;
import view.resources.*;
import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    private ConversationListPanel conversationListPanel;

    private ChatPanel chatPanel;

    // Labels
    private Label userNamelbl;
    private Label userNameTopRightlbl;

    // TextFields
    private GenericTextField chatmsg;

    // Buttons
    private GenericButton sendButton;
    private GenericButton userMenuButton;

    // ScrollPanes
    private ConversationsScrollPane conversationsScrollPane;
    private ChatScrollPane chatScrollPane;

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
        // Mostrar scrollpanes
        crearScrollPanes();


        // Añadir conversaciones de prueba
        conversationListPanel.addConversation("conversacion 1");
        conversationListPanel.addConversation("conversacion 2");
        conversationListPanel.addConversation("conversacion 3");

        setSize(800, 600);
        setTitle("Chats");
        setMinimumSize(new Dimension(800, 600));
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
         * Panel izquierdo
         * Lista de conversaciones y nombre de usuario
         */
        leftPanel = new LeftPanel();
        this.add(leftPanel, BorderLayout.WEST);

        /**
         * bottomLeftPanel GridBagLayout
         * Panel inferior izquierdo
         * Nombre de usuario
         */
        bottomLeftPanel = new BottomLeftPanel();
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        /**
         * rightPanel BorderLayout
         * Panel derecho
         * Chat
         */
        rightPanel = new RightPanel("defaultUser");
        add(rightPanel, BorderLayout.CENTER);



        // JPanel que contiene los ConversationPanel
        conversationListPanel = new ConversationListPanel();


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

    }
    /**
     * Iniciar todos los buttons del JFrame
     */
    private void crearButtons() {

    }
    /**
     * Iniciar todos los scrollpanes del JFrame
     */
    private void crearScrollPanes() {
        // JScrollPane conversaciones
        conversationsScrollPane = new ConversationsScrollPane();
        leftPanel.add(conversationsScrollPane, BorderLayout.CENTER);
        // Añadir panel conversaciones
        conversationsScrollPane.setViewportView(conversationListPanel);


    }

}
