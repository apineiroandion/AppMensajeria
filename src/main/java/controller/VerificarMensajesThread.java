package controller;

import model.dao.ConversacionDAO;

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
                    if(sustituirConversacionesUsuarioLogeado()){
                        enviarNotificacion();
                    }
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo que envia una notificacion al usuario logeado
     */
    public void enviarNotificacion() {
        System.out.println("Mensajes sin leer");
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
}