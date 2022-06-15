package modelo;

public class AutorVO {
    private int idAutor;
    private String nombreAutor;
    private String seudonimoAutor;
    private int edadAutor;
    private String generoAutor;
    
    public AutorVO(){
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
