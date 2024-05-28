package view;

import controller.UserController;
import model.User;
import view.resources.CloseButton;
import view.resources.GenericButton;
import view.resources.GenericTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class SearchWindow extends JFrame {
    private Point initialClick;
    /**
     * ArrayList de usuarios
     */
    private ArrayList<User> users;
    /**
     * Vector de strings de nombres de usuario
     */
    private Vector<String> userNames;
    /**
     * JTable de nombre de usuario
     */
    private JTable userTable;
    /**
     * JScrollPane de la tabla de usuarios
     */
    private JScrollPane userScrollPane;
    /**
     * Modelo de la tabla de usuarios
     */
    private DefaultTableModel tableModel;
    /**
     * GenericTextField primer mensaje
     */
    private GenericTextField firstMessage;
    /**
     * GenericButton enviar mensaje
     */
    private GenericButton sendMessage;
    /**
     * Constructor SearchWindow con el Jtable en el medio y el mensaje y el botón en la parte inferior
     */
    public SearchWindow(ArrayList<User> users) {
        this.users = users;
        userNames = new Vector<>();

        tableModel = new DefaultTableModel();

        // Añadir botones
        addButtons();

        // Añadir tabla de usuarios
        addTable();
        // Añadir columnas a la tabla
        tableModel.addColumn("Usuario");
        // Añadir usuarios a la tabla
        addUsers();
        // Añadir scrollPane
        addScrollPane();
        // Añadir TextField
        addTextField();
        // Añadir actionListener al botón de enviar
        addSendListener();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Localización de la ventana
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determinar cuánto se ha movido el ratón desde el click inicial
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Mover la ventana a la nueva posición
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });

        setTitle("Nueva conversación");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(50, 50, 50));
        setVisible(true);
    }

    /**
     * Añade los botones de la ventana
     */
    public void addButtons() {
        // Botón de cerrar
        JButton closebtn = new CloseButton();
        closebtn.setBounds(265, 0, 35, 35);
        add(closebtn);
        closebtn.addActionListener(e -> {
            dispose();
        });

        // Botón de enviar
        sendMessage = new GenericButton("Enviar");
        sendMessage.setBounds(200, 350, 75, 40);
        add(sendMessage);
    }

    /**
     * Añade el scrollPane de la tabla
     */
    public void addScrollPane() {
        userScrollPane = new JScrollPane(userTable);
        userScrollPane.setBounds(12, 50, 275, 300);
        // eliminar bordes
        userScrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(userScrollPane);
    }

    /**
     * Añade la tabla de usuarios
     */
    public void addTable() {
        userTable = new JTable();
        userTable.setBounds(50, 50, 275, 300);
        userTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
        userTable.setFillsViewportHeight(true);
        // cambiar color table
        userTable.setBackground(new Color(60, 60, 60));
        // cambiar color de la fuente
        userTable.setForeground(new Color(255, 255, 255));
        // cambiar color de la selección
        userTable.setSelectionBackground(new Color(115, 0, 255));
        // cambiar color de la cabecera
        userTable.getTableHeader().setBackground(new Color(60, 60, 60));
        // eliminar bordes cabecera
        userTable.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
        // cambiar color de la fuente cabecera
        userTable.getTableHeader().setForeground(new Color(255, 255, 255));
        // cambiar color de la cuadricula
        userTable.setGridColor(new Color(0, 0, 0));
        userTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    /**
     * Añade el textField de la ventana
     */
    public void addTextField() {
        firstMessage = new GenericTextField(200, 20, Color.BLACK);
        firstMessage.setBounds(12, 350, 175, 40);
        add(firstMessage);
    }
    /**
     * Añade los nombres de usuarios a la tabla recorriendo el arrayList de usuarios
     */
    public void addUsers() {
        for (User user : users) {
            userNames.add(user.getUserName());
        }
        for (String userName : userNames) {
            tableModel.addRow(new Object[]{userName});
        }
        userTable.setModel(tableModel);
    }
    /**
     * coge el string del jtext y lo devuelve
     * @return el string del jtext
     */
    public String getFirstMessage() {
        return firstMessage.getText();
    }
    /**
     * añade un nuevo acctionListener al boton de enviar
     */
    public void addSendListener() {
        sendMessage.addActionListener(e -> {
            int index = 0;
            int comprobador = 0;
            for(User user: users){
                if (user.getUserName().equals(userTable.getValueAt(userTable.getSelectedRow(), 0))) {
                    index = users.indexOf(user);
                    comprobador++;
                }
            }
            if(comprobador!=0){
                UserController.crearConversacion(getFirstMessage(), users.get(index));
                System.out.println("Mensaje enviado: ");
                dispose();
            }else {
                System.out.println("No se ha seleccionado un usuario");
            }
        });
    }

}
