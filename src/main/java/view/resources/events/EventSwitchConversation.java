package view.resources.events;

import view.MainWindow;
import view.MessageUpdater;
import view.panels.ConversationListPanel;
import view.panels.ConversationPanel;
import view.panels.RightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventSwitchConversation extends MouseAdapter {
    private String usuario;
    private int ID;
    private ConversationPanel conversationPanel;
    private ConversationListPanel parentPanel;
    RightPanel rightPanel;

    public EventSwitchConversation(String usuario, int ID, ConversationPanel conversationPanel, ConversationListPanel parentPanel) {
        this.usuario = usuario;
        this.ID = ID;
        this.conversationPanel = conversationPanel;
        this.parentPanel = parentPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Se ha hecho clic en el panel de conversación de " + usuario + "con ID: " + ID);
        conversationPanel.setBackground(new Color(40,40,40));
        parentPanel.changeColorOthers(conversationPanel); // Deseleccionar otros ConversationPanel

        // Create a new RightPanel
        rightPanel = new RightPanel(usuario, ID);

        // Get the MainWindow instance
        MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(conversationPanel);

        // Remove the old RightPanel
        Component[] components = mainWindow.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof RightPanel) {
                mainWindow.getContentPane().remove(component);
            }
        }

        // Add the new RightPanel to the MainWindow
        mainWindow.getContentPane().add(rightPanel, BorderLayout.CENTER);

        // Refresh the MainWindow
        mainWindow.getContentPane().validate();
        mainWindow.getContentPane().repaint();
    }
}