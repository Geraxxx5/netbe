package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class UsuarioDAO implements ConsultasUsuario{

    public JasperViewer jv;
    
    @Override
    public int verificacion(UsuarioVO uvo) {
        Conector c = new Conector();
        int tipoUsuario = 0;
        try {
            c.conectar();
            String query = "SELECT u.user_usuario, u.pass_usuario, u.fk_id_tipo_usuario, u.fk_id_estado FROM bdjuegofinal.usuario u";
            ResultSet rs = c.consultaDatos(query);
            String usuario;
            String pass;
            String estad;
            while(rs.next()){
                usuario = rs.getString("user_usuario");
                pass = rs.getString("pass_usuario");
                if((usuario.equals(uvo.getUserUsuario()))&&(pass.equals(uvo.getPassUsuario()))){
                    tipoUsuario = rs.getInt("fk_id_tipo_usuario");
                    if(rs.getString("fk_id_estado") == "0"){
                        tipoUsuario = -1;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error [MUVeri]: "+e.getMessage());
            c.desconectar();
        }
        return tipoUsuario;
    }

    
    @Override
    public boolean ingresarUsuario(UsuarioVO uvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO usuario(nombre_usuario, apellido_usuario, edad_usuario, user_usuario, pass_usuario, fk_id_estado,fk_id_tipo_usuario) VALUES ('"+uvo.getNombreUsuario()+"','"+uvo.getApellidoUsuario()+"',"+uvo.getEdadUsuario()+",'"+uvo.getUserUsuario()+"','"+uvo.getPassUsuario()+"',"+uvo.getFkIdEstado()+","+uvo.getFkIdTipoUsuario()+")";
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Error [MCIn]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> datosTabla() {
        ArrayList<UsuarioVO> list = new ArrayList<>();
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.edad_usuario, u.user_usuario, u.fk_id_estado, u.fk_id_tipo_usuario FROM bdjuegofinal.usuario u";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                UsuarioVO uvo = new UsuarioVO();
                uvo.setApellidoUsuario(rs.getString("apellido_usuario"));
                uvo.setEdadUsuario(rs.getInt("edad_usuario"));
                uvo.setFkIdTipoUsuario(rs.getInt("fk_id_tipo_usuario"));
                uvo.setFkIdEstado(rs.getInt("fk_id_estado"));
                uvo.setIdUsuario(rs.getInt("id_usuario"));
                uvo.setNombreUsuario(rs.getString("nombre_usuario"));
                uvo.setUserUsuario(rs.getString("user_usuario"));
                list.add(uvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [DatosTU]: "+e.getMessage());
            c.desconectar();
        }
        return list;
    }

    @Override
    public boolean borrar(UsuarioVO uvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdjuegofinal.usuario SET fk_id_estado = 0 WHERE id_usuario = "+uvo.getIdUsuario();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MCBorr]");
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean actualizar(UsuarioVO uvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdjuegofinal.usuario u SET u.nombre_usuario = '"+uvo.getNombreUsuario()+"', u.apellido_usuario = '"+uvo.getApellidoUsuario()+"', u.edad_usuario = "+uvo.getEdadUsuario()+", u.user_usuario = '"+uvo.getUserUsuario()+"', u.fk_id_estado = "+uvo.getFkIdEstado()+", u.fk_id_tipo_usuario = "+uvo.getFkIdTipoUsuario()+" WHERE u.id_usuario = "+uvo.getIdUsuario();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUACT]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    
    @Override
    public boolean vereficarExistencia(UsuarioVO uvo) {
        Conector c = new Conector();
        int resultado = 1;
        try {
            c.conectar();
            String query = "SELECT COUNT(*) verificar FROM bdjuegofinal.usuario WHERE user_usuario = '"+uvo.getUserUsuario()+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                resultado = rs.getInt("verificar");
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUVere]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        
        if(resultado == 0){
            return true;
        }
        return false;
    }

    @Override
    public int getId(UsuarioVO uvo) {
        int valor = 0;
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT u.id_usuario FROM bdjuegofinal.usuario u WHERE u.user_usuario = '"+uvo.getUserUsuario()+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getInt("id_usuario");
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [McgetId]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }

    @Override
    public void reporte() {
        Conector c = new Conector();
        try {
            c.conectar();
            JasperReport reporte;
            String ruta = "src\\reporte\\ReporteUsuario.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(ruta, null, c.connection);
            JasperViewer jv = new JasperViewer(jp, false);
            this.jv = jv;
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [RReporte]: "+e.getMessage());
            c.desconectar();
        }
    }
  
    
}
