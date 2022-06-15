package modelo;

import java.util.Date;

public class AutorLibroVO {
    int idLibro;
    int idAutorFk;
    String nombreLibro;
    Date fechaPublicacionLibro;
    int numeroPaginasLibro;
    String generoPrincipalLibro;
    private int idAutor;
    private String nombreAutor;
    private String seudonimoAutor;
    private int edadAutor;
    private String generoAutor;

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

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getSeudonimoAutor() {
        return seudonimoAutor;
    }

    public void setSeudonimoAutor(String seudonimoAutor) {
        this.seudonimoAutor = seudonimoAutor;
    }

    public int getEdadAutor() {
        return edadAutor;
    }

    public void setEdadAutor(int edadAutor) {
        this.edadAutor = edadAutor;
    }

    public String getGeneroAutor() {
        return generoAutor;
    }

    public void setGeneroAutor(String generoAutor) {
        this.generoAutor = generoAutor;
    }
    
    
}
