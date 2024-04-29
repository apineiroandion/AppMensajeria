package modelo;

import java.util.ArrayList;

public class Conversacion {
    private Integer idc;
    private Usuario usuarioUno;
    private Usuario usuarioDos;
    private ArrayList<Mensaje> mensajes;

    public Conversacion(Usuario usuarioUno, Usuario usuarioDosç) {
        this.usuarioUno = usuarioUno;
        this.usuarioDos = usuarioDos;
    }

    public Conversacion(Usuario usuarioUno, Usuario usuarioDos, ArrayList<Mensaje> mensajes) {
        this.usuarioUno = usuarioUno;
        this.usuarioDos = usuarioDos;
        this.mensajes = mensajes;
    }

    public Integer getIdc() {
        return idc;
    }

    public void setIdc(Integer idc) {
        this.idc = idc;
    }

    public Usuario getUsuarioUno() {
        return usuarioUno;
    }

    public void setUsuarioUno(Usuario usuarioUno) {
        this.usuarioUno = usuarioUno;
    }

    public Usuario getUsuarioDos() {
        return usuarioDos;
    }

    public void setUsuarioDos(Usuario usuarioDos) {
        this.usuarioDos = usuarioDos;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
