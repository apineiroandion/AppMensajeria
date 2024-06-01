package view.panels;

import view.resources.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Panel superior arrastrable de la ventana
 */
public class TopPanel extends JPanel {
    private Point initialClick;
    public TopPanel() {
        setLayout(new BorderLayout());
        setBackground(new java.awt.Color(40, 40, 40));
        setPreferredSize(new Dimension(0, 25));

        // Crear un panel para los botones
        WindowButtonsPanel buttonPanel = new WindowButtonsPanel();


        // Agregar el panel de botones al TopPanel
        add(buttonPanel, BorderLayout.EAST);

        Label label = new Label("Chats", 20);
        add(label, BorderLayout.WEST);
        // separar el label de la izquierda
        label.setBorder(new EmptyBorder(0, 10, 0, 0));

        // permitir que el panel se arrastre
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // localización de la ventana
                int thisX = getTopLevelAncestor().getLocation().x;
                int thisY = getTopLevelAncestor().getLocation().y;

                // Determinar cuánto se ha movido el mouse desde el clic inicial
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Mover la ventana a esta posición
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                getTopLevelAncestor().setLocation(X, Y);
            }
        });
    }
}
