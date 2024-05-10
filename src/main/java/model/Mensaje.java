package model;

public class Mensaje {
    private Integer idm;
    private Integer idc;
    private Integer idu;
    private String content;

    public Mensaje(Integer idc, Integer idu, String content) {
        this.idc = idc;
        this.idu = idu;
        this.content = content;
    }

    public Integer getIdm() {
        return idm;
    }

    public void setIdm(Integer idm) {
        this.idm = idm;
    }

    public Integer getIdc() {
        return idc;
    }

    public void setIdc(Integer idc) {
        this.idc = idc;
    }

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}