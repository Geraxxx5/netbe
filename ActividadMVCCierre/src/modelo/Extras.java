package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Extras {
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    
    public static boolean validarTablaVacia(){
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT COUNT(*) FROM bdactividadf.autor";
            ResultSet rs = c.consultaDatos(query);
            int count = 0;
            while(rs.next()){
                count = rs.getInt("COUNT(*)");
            }
            if(count == 0){
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error [MAlgo]: "+e);
            return false;
        }
        return true;
    }
    
    public static ArrayList<AutorVO> datosCombo() {
        ArrayList<AutorVO> list = new ArrayList<>();
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT a.id_autor, a.seudonimo_autor FROM bdactividadf.autor a";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                AutorVO avo = new AutorVO();
                avo.setIdAutor(rs.getInt("id_autor"));
                avo.setSeudonimoAutor(rs.getString("seudonimo_autor"));
                list.add(avo);
            }
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MdatosCobo]: "+e);
        }
        return list;
    }
    
    public static int retornarId(String seudonimo){
        Conector c = new Conector();
        int valor = 0;
        try {
            c.conectar();
            String query = "SELECT a.id_autor FROM bdactividadf.autor a WHERE a.seudonimo_autor = '"+seudonimo+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getInt("id_autor");
            }
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MCRetornarId]: "+e);
        }
        return valor;
    }
    
    public static String retornarSeudonimo(int idAutor){
        Conector c = new Conector();
        String valor = "";
        try {
            c.conectar();
            String query = "SELECT a.seudonimo_autor FROM bdactividadf.autor a WHERE a.id_autor = "+idAutor;
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getString("seudonimo_autor");
            }
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MCRetonarS]: "+e);
        }
        return valor;
    }
    
    public static boolean validarExistencia(String seudonimo){
        Conector c = new Conector();
        boolean bandera = false;
        try {
            c.conectar();
            String query = "SELECT * FROM bdactividadf.autor a WHERE a.seudonimo_autor = '"+seudonimo+"'";
            ResultSet rs = c.consultaDatos(query);
            if(rs.next()){
                bandera = true;
            }
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MCValidarExist]: "+e);
        }
        return bandera;
    }
    
    public static boolean validarEliminar(int idAutor){
        Conector c = new Conector();
        boolean bandera = false;
        try {
            c.conectar();
            String query = "SELECT * FROM bdactividadf.libro a WHERE a.id_autor_fk = "+idAutor;
            ResultSet rs = c.consultaDatos(query);
            if(rs.next()){
                bandera = true;
            }
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MCValidarExist]: "+e);
        }
        return bandera;
    }
}
