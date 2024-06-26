package controller;

import model.dao.ConversacionDAO;
import model.dao.MensajeDAO;
import view.MessageUpdater;

import java.util.ArrayList;
import  java.util.concurrent.atomic.AtomicBoolean;

/**
 * Esta clase es un thread que comprueba cada 2 segundos si hay mensajes nuevos en la base de datos
 * que no hayan sido leidos por el ususario logeado
 */
public class VerificarMensajesThread extends Thread{

    /**
     * Metodo run del thread
     */
    @Override
    public void run() {
        while (true) {
            try {
                if (ConversacionDAO.hayMensajesNoLeidos(UserController.usuarioLogeado.getUserName())) {
                    ArrayList<Integer> conversacionesConMensajesNoLeidos = MensajeDAO.getConversacionesConMensajesSinLeer(UserController.usuarioLogeado.getUserName());
                    UpdateMensajesThread.updateMensajesIsRunning(true);
                    MessageUpdater.updateIsRunning(true);
                    for (Integer conversacionId : conversacionesConMensajesNoLeidos) {
                        if(sustituirConversacionesUsuarioLogeado()){
                            //updateIsRunningTrue();
                            enviarNotificacion(conversacionId);
                        }
                    }
                }
                Thread.sleep(5000);
                //updateIsRunningFalse();
                MessageUpdater.updateIsRunning(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo que envia una notificacion al usuario logeado
     */
    public void enviarNotificacion(Integer conversacionId) {
        System.out.println("Hay mensajes sin leer en la conversación " + conversacionId);
    }

    /**
     * Metodo que sustituye el array de conversaciones del usuario logeado
     * @return true si se ha sustituido correctamente, false en caso contrario
     */
    public boolean sustituirConversacionesUsuarioLogeado() {
        UserController.conversacionesUsuarioLogeado = ConversacionDAO.getConversacionesByUserFromDB(UserController.usuarioLogeado);
        return true;
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

    /**
     * Metodo que reinicia el thread
     */
    public void reiniciarThread() {
        this.detenerThread();
        this.iniciarThread();
    }

    /**
     * Metodo que comprueba si el thread esta corriendo
     * @return true si el thread esta corriendo, false en caso contrario
     */
    public boolean isRunning() {
        System.out.println("Thread is running");
        return this.isAlive();
    }
//    /**
//     * Actualizar is running
//     */
//    public void updateIsRunningTrue() {
//        System.out.println("Updater is running");
//        MessageUpdater.updaterRunning =  true;
//    }
//    /**
//     * Actualizar is running fale
//     */
//    public void updateIsRunningFalse() {
//        System.out.println("Updater is not running");
//        MessageUpdater.updaterRunning =  false;
//    }
}