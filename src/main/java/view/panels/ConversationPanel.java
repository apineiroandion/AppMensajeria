package view.panels;

import view.MainWindow;
import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel de conversaciones
 */
public class ConversationPanel extends JPanel {
    private ConversationListPanel parentPanel; // Panel superior
    /**
     * Constructor
     * @param usuario Nombre de usuario
     * @param parentPanel Panel superior
     */
    public ConversationPanel(String usuario, ConversationListPanel parentPanel) {
        this.parentPanel = parentPanel;
        setPreferredSize(new Dimension(250,50));
        setMaximumSize(new Dimension(250,50));
        setBackground(new Color(50,50,50));
        setLayout(new BorderLayout());

        Label lbl = new Label(usuario,15);
        lbl.setBorder(new EmptyBorder(0, 10, 0, 0)); // Añade un borde vacío a la izquierda de la etiqueta
        this.add(lbl, BorderLayout.WEST);

        // Añadir MouseListener
        this.addMouseListener(new MouseAdapter() {
            // Cambiar color y cambiar chats al hacer clic
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Se ha hecho clic en el panel de conversación de " + usuario);
                setBackground(new Color(40,40,40));
                parentPanel.changeColorOthers(ConversationPanel.this); // Deseleccionar otros ConversationPanel

                // Create a new RightPanel
                RightPanel rightPanel = new RightPanel(usuario);

                // Get the MainWindow instance
                MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(ConversationPanel.this);

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
        });
    }
}
