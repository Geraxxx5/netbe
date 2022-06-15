package modelo;

import java.util.ArrayList;

public interface ConsultasAutor {
    public boolean insertarAutor(AutorVO avo);
    public boolean eliminarAutor(AutorVO avo);
    public ArrayList<AutorVO> consultarAutor();
    public boolean actualizarAutor(AutorVO avo);
}
