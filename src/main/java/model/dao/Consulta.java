package model.dao;

public interface Consulta {
    public static final String GET_ALL_USERS= "SELECT * FROM usuario";
    public String getQuery(String query);
}
