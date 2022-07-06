package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Extras {
    
    
    public static ArrayList<EstadoVO> datosComboEstado(){
        ArrayList<EstadoVO> list = new ArrayList<>();
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT e.nombre_estado FROM bdjuegofinal.estado e";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                EstadoVO evo = new EstadoVO();
                evo.setNombreEstado(rs.getString("nombre_estado"));
                list.add(evo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MDatosC]: "+e.getMessage());
            c.desconectar();
        }
        return list;
    }
    
    public static int retornarIdEstado(String estado){
        Conector c = new Conector();
        int valor = 0;
        try {
            c.conectar();
            String query = "SELECT e.id_estado FROM bdjuegofinal.estado e WHERE e.nombre_estado = '"+estado+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getInt("id_estado");
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MRIEstado]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }
    
    
    public static String retornarEstado(int idEstado){
        Conector c = new Conector();
        String valor = "";
        try {
            c.conectar();
            String query = "SELECT e.nombre_estado FROM bdjuegofinal.estado e WHERE e.id_estado = "+idEstado;
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getString("nombre_estado");
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [ERE]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }
    
    public static ArrayList<TipoUsuarioVO> datosComboTipoUsuario(){
        ArrayList<TipoUsuarioVO> list = new ArrayList<>();
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT t.nombre_tipo_usuario FROM bdjuegofinal.tipo_usuario t";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                TipoUsuarioVO tuvo = new TipoUsuarioVO();
                tuvo.setNombreTipoUsuario(rs.getString("nombre_tipo_usuario"));
                list.add(tuvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MDatosC]: "+e.getMessage());
            c.desconectar();
        }
        return list;
    }
    
    public static int retornarIdTipoUsuario(String TipoUsuario){
        Conector c = new Conector();
        int valor = 0;
        try {
            c.conectar();
            String query = "SELECT t.id_tipo_usuario FROM bdjuegofinal.tipo_usuario t WHERE t.nombre_tipo_usuario = '"+TipoUsuario+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getInt("id_tipo_usuario");
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MRITipoUsuario]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }
    
    public static String retornarTipoUsuario(int idTipoUsuario){
        String valor = "";
        Conector c = new Conector();
        try {
            String query = "SELECT t.nombre_tipo_usuario FROM bdjuegofinal.tipo_usuario t WHERE t.id_tipo_usuario = "+idTipoUsuario;
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getString("nombre_tipo_usuario");
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [RTP]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }
    
}
