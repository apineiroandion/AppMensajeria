package controller;

import model.dao.MensajeDAO;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Esta clase es un thread que marca los mensajes de la conversacion abierta
 * como leidos cuando el usuario logeado sea distinto al usurio que envio el mensaje
 */
public class UpdateMensajesThread extends Thread {
    /**
     * Metodo run del thread, marca los mensajes de la conversacion abierta como leidos
     */
    public static AtomicBoolean updateMensajes = new AtomicBoolean(false);
    @Override
    public void run() {
        while (true) {
            try {
                if (UserController.conversacionAbierta != null) {
                    if(MensajeDAO.hayMensajesNoLeidos(UserController.conversacionAbierta.getCodigoConversacion()) && updateMensajes.get()){
                        MensajeDAO.marcarMensajesComoLeidos(UserController.conversacionAbierta.getCodigoConversacion());
                        updateMensajes.set(false);
                    }
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo estatico que pone updateMensajes a true o false segun lo que reciba
     * @param running true para poner updateMensajes a true, false para ponerlo a false
     */
    public static void updateMensajesIsRunning(boolean running) {
        updateMensajes.set(running);
        System.out.println("UpdateMensajes running: " + updateMensajes.get());
    }

    /**
     * Metodo que inicia el thread
     */
    public void iniciarThread() {
        this.start();
    }

    /**
     * Metodo que detiene el thread
     */
    public void detenerThread() {
        this.interrupt();
    }

}
