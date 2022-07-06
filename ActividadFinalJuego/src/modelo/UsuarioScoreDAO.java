package modelo;

import conexion.Conector;
import java.sql.ResultSet;

public class UsuarioScoreDAO implements ConsultasUsuarioScore{

    @Override
    public String consultarDatos(String consulta, String usuario) {
        Conector c = new Conector();
        String valor = "";
        try {
            c.conectar();
            String query = "SELECT "+consulta+" FROM bdjuegofinal.usuario u INNER JOIN bdjuegofinal.score s ON u.id_usuario = s.fk_id_usuario WHERE u.user_usuario = '"+usuario+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getString(consulta);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUSD]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }

    @Override
    public boolean existenciaTablaScore(UsuarioScoreVO usvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT u.id_usuario FROM bdjuegofinal.usuario u INNER JOIN bdjuegofinal.score s ON u.id_usuario = s.fk_id_usuario WHERE u.user_usuario = '"+usvo.getUserUsuario()+"'";
            ResultSet rs = c.consultaDatos(query);
            if(!(rs.next())){
                this.crearTabla(Integer.parseInt(this.consultaDatosUsuario("id_usuario", usvo.getUserUsuario())));
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MEXTSL]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public void crearTabla(int idUsuario) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO score(punteo_score,fk_id_usuario) VALUES(0,"+idUsuario+")";
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MUSCrear]: "+e.getMessage());
        }
        
    }

    @Override
    public String consultaDatosUsuario(String consulta, String usuario) {
        Conector c = new Conector();
        String valor = "";
        try {
            c.conectar();
            String query = "SELECT "+consulta+" FROM bdjuegofinal.usuario u WHERE u.user_usuario = '"+usuario+"'";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                valor = rs.getString(consulta);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUSD]: "+e.getMessage());
            c.desconectar();
        }
        return valor;
    }

    @Override
    public boolean cambiarPunteo(UsuarioScoreVO usvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdjuegofinal.score s SET s.punteo_score = "+usvo.getPunteoScore()+" WHERE s.id_score = "+usvo.getIdScore();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUSCPuntos]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean subirNivel(UsuarioScoreVO usvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdjuegofinal.usuario u SET u.fk_id_tipo_usuario = "+usvo.getFkIdTipoUsuario()+" WHERE u.id_usuario = "+usvo.getIdUsuario();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUSsubir]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public boolean modificarUsuario(UsuarioScoreVO usvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdjuegofinal.usuario u SET u.nombre_usuario = '"+usvo.getNombreUsuario()+"', u.apellido_usuario = '"+usvo.getApellidoUsuario()+"', u.edad_usuario = "+usvo.getEdadUsuario()+", u.user_usuario = '"+usvo.getUserUsuario()+"', u.pass_usuario = '"+usvo.getPassUsuario()+"' WHERE u.id_usuario = "+usvo.getIdUsuario();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MUSModificar]: "+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }
    
    
    
}
