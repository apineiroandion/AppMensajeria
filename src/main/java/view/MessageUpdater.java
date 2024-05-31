package view;
import controller.VerificarMensajesThread;
import view.panels.RightPanel;

import  java.util.concurrent.atomic.AtomicBoolean;

public class MessageUpdater extends Thread{
    private RightPanel rightPanel;
    private int conversationId;
    public static AtomicBoolean updaterRunning = new AtomicBoolean(false);

    public MessageUpdater(RightPanel rightPanel, int conversationId) {
        this.rightPanel = rightPanel;
        this.conversationId = conversationId;
    }

    @Override
    public void run() {
        // Actualizar los mensajes
        while (updaterRunning.get()){ // Mientras el hilo de verificación de mensajes esté corriendo
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
        System.out.println("Start message update");
        this.start();
    }

    public void stopMessageUpdate() {
        this.interrupt();
    }

    /**
     * Metodo estatico que pone updaterRunning a true o false segun lo que reciba
     * @param running true para poner updaterRunning a true, false para ponerlo a false
     */
    public static void updateIsRunning(boolean running) {
        updaterRunning.set(running);
        System.out.println("Updater running: " + updaterRunning.get());
    }


}