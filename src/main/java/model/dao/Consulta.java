package model.dao;

public interface Consulta {
    public static final String GET_ALL_USERS= "SELECT * FROM usuario";
    public static final String GET_ALL_CONVERSATIONS = "SELECT * FROM conversacion";
    public String getQuery(String query);
}
