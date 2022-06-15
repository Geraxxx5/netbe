package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;

public class AutorDAO implements ConsultasAutor {
    
    @Override
    public boolean insertarAutor(AutorVO avo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO autor (nombre_autor,seudonimo_autor,edad_autor,genero_autor) VALUES "+
                    "('"+avo.getNombreAutor()+"', '"+avo.getSeudonimoAutor()+"', "+avo.getEdadAutor()+", '"+avo.getGeneroAutor()+"')";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [MInsert]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminarAutor(AutorVO avo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM bdactividadf.autor WHERE id_autor = "+avo.getIdAutor();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error [MElimi]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<AutorVO> consultarAutor() {
        Conector c = new Conector();
        ArrayList<AutorVO> list = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT id_autor,nombre_autor,seudonimo_autor,edad_autor,genero_autor FROM bdactividadf.autor";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                AutorVO avo = new AutorVO();
                avo.setIdAutor(rs.getInt(1));
                avo.setNombreAutor(rs.getString(2));
                avo.setSeudonimoAutor(rs.getString(3));
                avo.setEdadAutor(rs.getInt(4));
                avo.setGeneroAutor(rs.getString(5));
                list.add(avo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MCons]: "+e.getMessage());
            c.desconectar();
        }
        return list;
    }

    @Override
    public boolean actualizarAutor(AutorVO avo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdactividadf.autor a SET a.nombre_autor = '"+avo.getNombreAutor()+"', a.seudonimo_autor = '"+avo.getSeudonimoAutor()+"', a.edad_autor = "+avo.getEdadAutor()+",a.genero_autor = '"+avo.getGeneroAutor()+"' WHERE a.id_autor = "+avo.getIdAutor();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MActua]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    
}
