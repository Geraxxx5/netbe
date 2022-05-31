package modelo;

import java.util.Date;

public class PaisVO {
    private int idPais;
    private String nombrePais;
    private String capitalPais;
    private long poblacionPais;
    private Date FechaIngPais;
    private Date FechaActPais;

    public PaisVO() {
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public long getPoblacionPais() {
        return poblacionPais;
    }

    public void setPoblacionPais(long poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public Date getFechaIngPais() {
        return FechaIngPais;
    }

    public void setFechaIngPais(Date FechaIngPais) {
        this.FechaIngPais = FechaIngPais;
    }

    public Date getFechaActPais() {
        return FechaActPais;
    }

    public void setFechaActPais(Date FechaActPais) {
        this.FechaActPais = FechaActPais;
    }
    
    
}