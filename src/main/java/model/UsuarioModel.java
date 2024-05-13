package model;

import java.util.ArrayList;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class UsuarioModel {
    private ArrayList<Usuario> usuarios;

    public UsuarioModel() {

    }

    /**
     * Metodo que crea un nuevo ususario
     * @param userName
     * @param firstName
     * @param surName
     * @param password
     * @return el usuario creado
     */
    public Usuario nuevoUsuario(String userName, String firstName, String surName, String password){
        return new Usuario(userName, firstName, surName, password);
    }

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
