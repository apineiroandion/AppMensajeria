package model;

import java.util.ArrayList;

public class UsuarioModel {
    private ArrayList<Usuario> usuarios;



    public UsuarioModel(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
