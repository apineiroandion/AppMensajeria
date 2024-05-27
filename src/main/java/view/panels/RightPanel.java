package view.panels;

import view.resources.ChatScrollPane;
import view.resources.GenericButton;
import view.resources.GenericTextField;
import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
    public RightPanel(String userName){
        setBackground(new Color(45,45,45));
        setLayout(new BorderLayout());

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

        // Añadir mensajes de prueba
        chatPanel.addMessage("Hola "+ userName, true,chatScrollPane);
        chatPanel.addMessage("Que tal", false, chatScrollPane);
        chatPanel.addMessage("Bien", true, chatScrollPane);

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
            chatPanel.addMessage(chatmsg.getText(), true, chatScrollPane);
            chatmsg.setText("");
        });

        // TODO: ponerle un simbolo de menú
        // JButton menú usuario
        userMenuButton = new GenericButton("Menu");
        topRightPanel.add(userMenuButton, BorderLayout.EAST);
    }
}
