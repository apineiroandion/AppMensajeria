package view.resources.events;

import controller.UserController;
import model.Conversacion;
import view.panels.RightPanel;
import view.resources.ChatScrollPane;
import view.resources.GenericTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventSendMessage implements ActionListener {
    GenericTextField chatmsg;
    RightPanel rightPanel;
    ChatScrollPane chatScrollPane;
    int id;
    public EventSendMessage(GenericTextField chatmsg, RightPanel rightPanel, int id, ChatScrollPane chatScrollPane) {
        this.chatmsg = chatmsg;
        this.rightPanel = rightPanel;
        this.id = id;
        this.chatScrollPane = chatScrollPane;
    }

    /**
     * Evento enter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!chatmsg.getText().equals("")) {
            Conversacion conversacion= UserController.getConversacionFromId(id);
            UserController.enviarMensaje(chatmsg.getText(), conversacion);
            chatmsg.setText("");
            chatScrollPane.getVerticalScrollBar().setValue(chatScrollPane.getVerticalScrollBar().getMaximum());
        }
    }
}
