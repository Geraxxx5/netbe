package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class PaisDAO implements ConsultasPais {

    
    public JasperViewer jv;
    
    @Override
    public boolean insertar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO pais (nombre_pais, "+
                    "capital_pais,poblacion_pais,fecha_ingreso_pais) "
                    +"VALUES ('"+p.getNombrePais()+"','"+p.getCapitalPais()+"',"
                    +p.getPoblacionPais()+", '"+p.getFechaIngPais()+"')";
            
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
    public ArrayList<PaisVO> consultar() {
        Conector c = new Conector();
        ArrayList<PaisVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query = "SELECT p.id_pais, p.nombre_pais, p.capital_pais, p.poblacion_pais" +
            " FROM bdconector.pais p;";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                PaisVO pvo = new PaisVO();
                pvo.setIdPais(rs.getInt(1));
                pvo.setNombrePais(rs.getString(2));
                pvo.setCapitalPais(rs.getString(3));
                pvo.setPoblacionPais(rs.getLong(4));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MMostrar]: "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean actualizar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdconector.pais p " +
                            "SET p.nombre_pais = '"+p.getNombrePais()+"', p.capital_pais = '"+p.getCapitalPais()+"', p.poblacion_pais = '"+p.getPoblacionPais()+"', p.fecha_actualiza_pais = '"+p.getFechaActPais()+"' "+
                            "WHERE p.id_pais = "+p.getIdPais();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MMostrar]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM bdconector.pais " +
                            "WHERE id_pais = "+p.getIdPais();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MMostrar]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public void reporte() {
        Conector c = new Conector();
        try {
            c.conectar();
            JasperReport reporte;
            String ruta = "src\\reporte\\newReport.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(ruta, null, c.connection);
            JasperViewer jv = new JasperViewer(jp, false);
            this.jv = jv;
            
        } catch (Exception e) {
            System.err.println("Error [MCEliminar]: "+e.getMessage());
            c.desconectar();
        }
    }
    
}
