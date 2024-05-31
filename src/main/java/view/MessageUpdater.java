package view;
import view.panels.RightPanel;

import javax.swing.*;
import java.util.List;

public class MessageUpdater extends Thread{
    private RightPanel rightPanel;
    private int conversationId;

    public MessageUpdater(RightPanel rightPanel, int conversationId) {
        this.rightPanel = rightPanel;
        this.conversationId = conversationId;
    }

    @Override
    public void run() {
        // Actualizar los mensajes
        while (true){
            try {
                rightPanel.updateMessages(conversationId);
                rightPanel.validate();
                rightPanel.repaint();
                System.out.println("rula");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startMessageUpdate() {
        this.start();
    }

    public void stopMessageUpdate() {
        this.interrupt();
    }

}