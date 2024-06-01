package view.resources;

import view.resources.events.EventBorderColor;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase representa un campo de contraseña genérico con estilo y comportamiento personalizados.
 * Extiende la clase JPasswordField del paquete javax.swing.
 */
public class GenericPasswordFIeld extends JPasswordField {
    /**
     * Constructor para la clase GenericPasswordField.
     *
     * @param ancho       El ancho del campo de contraseña.
     * @param alto        La altura del campo de contraseña.
     * @param borderColor El color del borde cuando el campo no está enfocado.
     */
    public GenericPasswordFIeld(int ancho, int alto, Color borderColor) {
        // Establece el tamaño del campo de contraseña.
        setSize(ancho, alto);

        // Establece el carácter que se utilizará para hacer eco de la contraseña.
        setEchoChar('*');

        // Establece la fuente del campo de contraseña.
        setFont(new Font("Arial", Font.PLAIN, 15));

        // Establece el borde del campo de contraseña.
        setBorder(BorderFactory.createLineBorder(borderColor, 2));

        // Establece el color de primer plano del campo de contraseña.
        setForeground(new Color(175, 175, 175));

        // Establece el color de fondo del campo de contraseña.
        setBackground(new Color(40, 40, 40));

        // Agrega un listener de enfoque para cambiar el color del borde cuando el campo está enfocado.
        addFocusListener(new EventBorderColor(this, borderColor, Color.white));
    }
}