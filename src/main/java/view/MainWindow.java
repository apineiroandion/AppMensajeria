package view;

import controller.UserController;
import model.Conversacion;
import model.User;
import view.panels.*;
import view.resources.*;
import view.resources.Label;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Frame ventana principal
 */
public class MainWindow extends JFrame {
    // Paneles
    private LeftPanel leftPanel;
    private BottomLeftPanel bottomLeftPanel;
    private ConversationListPanel conversationListPanel;


    // Labels
    private Label userNamelbl;

    // TextFields

    // Buttons
    private GenericButton userAddButton;

    // ScrollPanes
    private ConversationsScrollPane conversationsScrollPane;

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
        setUndecorated(true);
        getContentPane().setBackground(new java.awt.Color(45, 45, 45));
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

        // Verificar que hay conversaciones
        if (conversaciones == null || conversaciones.isEmpty()) {
            System.out.println("No hay conversaciones para el usuario logeado.");
            return;
        }

        System.out.println("Conversaciones: " + conversaciones.get(0).getParticipantes());

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

        /**
         * topPanel BorderLayout
         * Panel superior
         * Botones cerrar y minimizar
         */
        TopPanel topPanel = new TopPanel();
        this.add(topPanel, BorderLayout.NORTH);

    }
    /**
     * Iniciar todos los labels del JFrame
     */
    private void crearLabels(){
        // Label UserName
        userNamelbl = new Label(UserController.usuarioLogeado.getUserName(),15);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        bottomLeftPanel.add(userNamelbl, gbc);



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
        userAddButton = new GenericButton("añadir conversacion");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        bottomLeftPanel.add(userAddButton, gbc);
        userAddButton.addActionListener(e -> {
            UserController.openSearchWindow();
        });
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
