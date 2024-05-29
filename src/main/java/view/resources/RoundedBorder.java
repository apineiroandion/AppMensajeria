package view.resources;

import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Borde redondeado para la burbujas de chat
 */
public class RoundedBorder extends LineBorder {
    private int radius;
    /**
     * Constructor
     * @param color color del borde
     * @param thickness grosor del borde
     * @param radius radio de las esquinas
     */
    public RoundedBorder(Color color, int thickness, int radius) {
        super(color, thickness);
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getLineColor());
        g2d.drawRoundRect(x, y, width - getThickness(), height - getThickness(), radius, radius);
    }
}
