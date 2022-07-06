package actividadfinaljuego;

import controlador.ControladorAdminModificar;
import controlador.ControladorAvanzado;
import controlador.ControladorBorrarUsuario;
import controlador.ControladorIndex;
import controlador.ControladorInsertarUsuario;
import controlador.ControladorIntermedio;
import controlador.ControladorMenuAdmin;
import controlador.ControladorMirarUsuarios;
import controlador.ControladorModificarUsuarioPropio;
import controlador.ControladorPrincipiante;
import modelo.EstadoVO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioScoreDAO;
import modelo.UsuarioScoreVO;
import modelo.UsuarioVO;
import vista.FrmAdminActualizarUsu;
import vista.FrmAdminBorrarUsu;
import vista.FrmAdminMirarUsuario;
import vista.FrmAdminNuevoUsuario;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIndex;
import vista.FrmIntermedio;
import vista.FrmModificarUsuario;
import vista.FrmPrincipiante;

public class ActividadFinalJuego {

    public static void main(String[] args) {
        //Administrador
        FrmAdministrador fad = new FrmAdministrador();
        FrmAdminNuevoUsuario fanu = new FrmAdminNuevoUsuario();
        FrmAdminBorrarUsu fabu = new FrmAdminBorrarUsu();
        FrmAdminMirarUsuario famu = new FrmAdminMirarUsuario();
        FrmAdminActualizarUsu faau = new FrmAdminActualizarUsu();
        //index
        FrmIndex findex = new FrmIndex();
        //Juego
        FrmPrincipiante fpri = new FrmPrincipiante();
        FrmIntermedio finter = new FrmIntermedio();
        FrmAvanzado fanzado = new FrmAvanzado();
        
        FrmModificarUsuario fmu = new FrmModificarUsuario();
        
        //daovo usuario
        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO adao = new UsuarioDAO();
        
        UsuarioScoreVO usvo = new UsuarioScoreVO();
        UsuarioScoreDAO usdao = new UsuarioScoreDAO();
        
        //daovo extras
        EstadoVO evo = new EstadoVO();
        TipoUsuarioVO tuvo = new TipoUsuarioVO();
        
        ControladorIndex cix = new ControladorIndex(fmu, fanzado, finter, fpri, findex, fad, uvo, adao, usvo, usdao);
        ControladorMenuAdmin cma = new ControladorMenuAdmin(fad, fanu, faau, fabu, famu);
        ControladorInsertarUsuario ciu = new ControladorInsertarUsuario(fad, fanu, evo, tuvo, uvo);
        ControladorBorrarUsuario cbu = new ControladorBorrarUsuario(fabu, fad, uvo, adao);
        ControladorAdminModificar cam = new ControladorAdminModificar(fad, faau, uvo, adao);
        ControladorMirarUsuarios cmu = new ControladorMirarUsuarios(famu, fad, uvo, adao);
        
        
        findex.setVisible(true);
    }
    
}
