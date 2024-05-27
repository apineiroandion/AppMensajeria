package view;

import controller.UserController;
import model.Conversacion;
import model.User;
import model.dao.ConversacionDAO;
import view.panels.*;
import view.resources.*;
import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

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
        /*conversationListPanel.addConversation("conversacion 1");
        conversationListPanel.addConversation("conversacion 2");
        conversationListPanel.addConversation("conversacion 3");*/

        addConversationPanel();


        setSize(800, 600);
        setTitle("Chats");
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addConversationPanel() {
        // Obtener las conversaciones del usuario logeado
        ArrayList<Conversacion> conversaciones = UserController.getConversacionesUsuarioLogeado(UserController.usuarioLogeado);
        System.out.println("Conversaciones: " + conversaciones);
        System.out.println("Conversaciones: " + conversaciones.size());
        System.out.println("Conversaciones: " + conversaciones.get(0).getParticipantes());

        // Verificar que hay conversaciones
        if (conversaciones == null || conversaciones.isEmpty()) {
            System.out.println("No hay conversaciones para el usuario logeado.");
            return;
        }

        // Imprimir los participantes de la primera conversación para depuración
        System.out.println(conversaciones.get(0).getParticipantes());

        // Iterar sobre las conversaciones
        for (Conversacion conversacion : conversaciones) {
            // Obtener los participantes de la conversación
            ArrayList<User> participantes = conversacion.getParticipantes();

            // Verificar que hay participantes
            if (participantes == null || participantes.isEmpty()) {
                System.out.println("Conversación sin participantes.");
                continue;
            }

            // Obtener el nombre de la conversación
            String conversationName = getConversationName(participantes);

            // Obtener el ID de la conversación
            int ID = conversacion.getCodigoConversacion();

            // Verificar que el nombre de la conversación no es nulo
            if (conversationName != null) {
                // Agregar la conversación al panel
                conversationListPanel.addConversation(conversationName, ID);
            } else {
                System.out.println("No se encontró un nombre de conversación válido para la conversación con participantes: " + participantes);
            }
        }

        // Asegurarse de actualizar el UI
        conversationListPanel.revalidate();
        conversationListPanel.repaint();
    }

    public String getConversationName(ArrayList<User> users) {
        for (User user : users) {
            if (!user.getUserName().equals(UserController.usuarioLogeado.getUserName())) {
                return user.getUserName();
            }
        }
        return null; // Devuelve null si todos los usuarios son el usuario logeado
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
/*        rightPanel = new RightPanel("defaultUser", 1);
        add(rightPanel, BorderLayout.CENTER);*/



        // JPanel que contiene los ConversationPanel
        conversationListPanel = new ConversationListPanel();


    }
    /**
     * Iniciar todos los labels del JFrame
     */
    private void crearLabels(){
        // Label UserName
        userNamelbl = new Label(UserController.usuarioLogeado.getUserName(),15);
        bottomLeftPanel.add(userNamelbl);

        GenericButton userMenuButton = new GenericButton("añadir");
        bottomLeftPanel.add(userMenuButton);
        userMenuButton.addActionListener(e -> {
            UserController.openSearchWindow();
        });

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
