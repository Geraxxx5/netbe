package modelo;

import java.util.Date;

public class LibroVO {
    int idLibro;
    int idAutorFk;
    String nombreLibro;
    Date fechaPublicacionLibro;
    int numeroPaginasLibro;
    String generoPrincipalLibro;

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdAutorFk() {
        return idAutorFk;
    }

    public void setIdAutorFk(int idAutorFk) {
        this.idAutorFk = idAutorFk;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Date getFechaPublicacionLibro() {
        return fechaPublicacionLibro;
    }

    public void setFechaPublicacionLibro(Date fechaPublicacionLibro) {
        this.fechaPublicacionLibro = fechaPublicacionLibro;
    }

    public int getNumeroPaginasLibro() {
        return numeroPaginasLibro;
    }

    public void setNumeroPaginasLibro(int numeroPaginasLibro) {
        this.numeroPaginasLibro = numeroPaginasLibro;
    }

    public String getGeneroPrincipalLibro() {
        return generoPrincipalLibro;
    }

    public void setGeneroPrincipalLibro(String generoPrincipalLibro) {
        this.generoPrincipalLibro = generoPrincipalLibro;
    }
    
    
}
