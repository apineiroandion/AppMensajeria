package view.panels;

import view.resources.CloseButton;
import view.resources.MaximizeButton;
import view.resources.MinimizeButton;

import javax.swing.*;
import java.awt.*;

/**
 * Panel de botones minimizar, maximizar y cerrar para la ventana
 */
public class WindowButtonsPanel extends JPanel {
    public WindowButtonsPanel() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        // establecer el color de fondo del panel de botones
        setBackground(new java.awt.Color(40, 40, 40));

        // Crear los botones
        CloseButton closeButton = new CloseButton();
        closeButton.setPreferredSize(new Dimension(40, 25));
        MinimizeButton minimizeButton = new MinimizeButton();
        MaximizeButton maximizeButton = new MaximizeButton();

        // Agregar los botones al panel
        add(minimizeButton);
        add(maximizeButton);
        add(closeButton);
    }
}
