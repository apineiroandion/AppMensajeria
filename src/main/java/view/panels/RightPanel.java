package view.panels;

import controller.UserController;
import model.Conversacion;
import model.Mensaje;
import model.dao.ConversacionDAO;
import model.dao.MensajeDAO;
import view.resources.ChatScrollPane;
import view.resources.GenericButton;
import view.resources.GenericTextField;
import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel derecho de la ventana principal.
 */
public class RightPanel extends JPanel {
    private TopRightPanel topRightPanel;
    private BottomRightPanel bottomRightPanel;
    private ChatScrollPane chatScrollPane;
    private ChatPanel chatPanel;
    private GridBagConstraints gbcrightBottomPanel;
    private GenericTextField chatmsg;
    private GenericButton sendButton;
    private GenericButton userMenuButton;
    private Label userNameTopRightlbl;

    /**
     * Constructor RightPanel
     * @param userName Nombre de usuario
     */
    public RightPanel(String userName, int ID){
        setBackground(new Color(45,45,45));
        setLayout(new BorderLayout());

        UserController.conversacionAbierta = getConversacionFromId(ID); // Establecer conversacion abierta

        /**
         * topRightPanel GridBagLayout
         * Panel superior derecho
         * Nombre usuario chat
         */
        topRightPanel = new TopRightPanel();
        add(topRightPanel, BorderLayout.NORTH);

        // Label UserName panel derecho arriba
        userNameTopRightlbl = new Label(userName,20);
        // Añadir un borde a la izquierda para que la label no esté pegada al borde
        userNameTopRightlbl.setBorder(new EmptyBorder(0, 10, 0, 0));
        topRightPanel.add(userNameTopRightlbl, BorderLayout.WEST);

        /**
         * bottomRightPanel GridBagLayout
         * Panel inferior derecho
         * Textfield y botón enviar
         */
        bottomRightPanel = new BottomRightPanel();
        add(bottomRightPanel, BorderLayout.SOUTH);


        // JPanel que contiene los mensajes de chat
        chatPanel = new ChatPanel();

        // JScrollPane chat
        chatScrollPane = new ChatScrollPane();
        add(chatScrollPane, BorderLayout.CENTER);
        // Añadir panel mensajes
        chatScrollPane.setViewportView(chatPanel);


        updateMessages(ID);

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

        // JButton enviar
        sendButton = new GenericButton("Enviar");
        sendButton.setPreferredSize(new Dimension(sendButton.getWidth(),50));
        gbcrightBottomPanel.gridx = 1;
        gbcrightBottomPanel.gridy = 0;
        gbcrightBottomPanel.weightx = 0.2;
        gbcrightBottomPanel.weighty = 1;
        gbcrightBottomPanel.fill = GridBagConstraints.BOTH;
        bottomRightPanel.add(sendButton,gbcrightBottomPanel);
        sendButton.addActionListener(e -> {
            // no permitir mensajes vacios o con espacios
            if(chatmsg.getText().trim().isEmpty()){
                return;
            }
            
            UserController.enviarMensaje(chatmsg.getText(), getConversacionFromId(ID));
            chatPanel.addMessage(chatmsg.getText(), true, chatScrollPane);
            chatmsg.setText("");
        });

        // TODO: ponerle un simbolo de menú
        // JButton menú usuario
        userMenuButton = new GenericButton("Menu");
        topRightPanel.add(userMenuButton, BorderLayout.EAST);
    }

    /**
     * Metodo que recorre las conversaciones del usuario logeado y devuelve la conversacion que tiene el mismo ID que se le pasa
     * @param id Id de la conversacion que se busca
     * @return conversacion resultado
     */
    public Conversacion getConversacionFromId(int id) {
        ArrayList<Conversacion> conversacions = ConversacionDAO.getConversacionesByUserFromDB(UserController.usuarioLogeado);
        for (Conversacion conversacion : conversacions) {
            System.out.println(conversacion);
            if (conversacion.getCodigoConversacion() == id) {
                return conversacion;
            }
        }
        return null;
    }


    /**
     * Actualiza los mensajes en el ChatPanel para la conversación dada.
     * @param conversationId el ID de la conversación.
     */
    public void updateMessages(int conversationId) {
        // Limpia el ChatPanel
        chatPanel.removeAll();

        // Obtén los mensajes de la base de datos
        ArrayList<Mensaje> mensajes = MensajeDAO.getMensajesFromDB(conversationId);

        // Añade los mensajes al ChatPanel
        for (Mensaje mensaje : mensajes) {
            System.out.println("Mensaje: " + mensaje.getContenido() + " " + mensaje.getEmisor().getUserName() + " " + conversationId);
            // Determina si el mensaje fue enviado por el usuario actual
            boolean isUserMessage = !mensaje.getEmisor().getUserName().equals(userNameTopRightlbl.getText());

            // Añade el mensaje al ChatPanel
            chatPanel.addMessage(mensaje.getContenido(), isUserMessage, chatScrollPane);
        }

        // Actualiza el ChatPanel para mostrar los nuevos mensajes
        chatPanel.revalidate();
        chatPanel.repaint();
    }

    /**
     * Añade un mensaje al ChatPanel.
     * @param message el mensaje a añadir.
     * @param isUserMessage true si el mensaje fue enviado por el usuario actual, false en caso contrario.
     */
    public void addMessage(String message, boolean isUserMessage) {
        chatPanel.addMessage(message, isUserMessage, chatScrollPane);
    }
}
