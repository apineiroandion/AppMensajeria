package controller;

import model.dao.MensajeDAO;

/**
 * Esta clase es un thread que marca los mensajes de la conversacion abierta
 * como leidos cuando el usuario logeado sea distinto al usurio que envio el mensaje
 */
public class UpdateMensajesThread extends Thread {
    /**
     * Metodo run del thread, marca los mensajes de la conversacion abierta como leidos
     */
    @Override
    public void run() {
        while (true) {
            try {
                if (UserController.conversacionAbierta != null) {
                    if(MensajeDAO.hayMensajesNoLeidos(UserController.conversacionAbierta.getCodigoConversacion())) {
                        MensajeDAO.marcarMensajesComoLeidos(UserController.conversacionAbierta.getCodigoConversacion());
                    }
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
