package actividadmvccierre;

import conexion.Conector;
import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMenuAutores;
import controlador.ControladorMenuLibros;
import controlador.ControladorMostrar;
import controlador.ControladorMostrarTodo;
import modelo.AutorDAO;
import modelo.AutorLibroDAO;
import modelo.AutorLibroVO;
import modelo.AutorVO;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmActualizacionLibro;
import vista.FrmActualizarAutores;
import vista.FrmAutores;
import vista.FrmEliminarAutor;
import vista.FrmEliminarLibro;
import vista.FrmInsertarAutores;
import vista.FrmInsertarLibro;
import vista.FrmLibros;
import vista.FrmMenuPrincipal;
import vista.FrmMostrarAutor;
import vista.FrmMostrarGeneral;
import vista.FrmMostrarLibros;

public class ActividadMVCCierre {

    public static void main(String[] args) {
        FrmMenuPrincipal fm = new FrmMenuPrincipal();
        //Menu Autores
        FrmInsertarAutores fia = new FrmInsertarAutores();
        FrmAutores fa = new FrmAutores();
        FrmEliminarAutor fea = new FrmEliminarAutor();
        FrmActualizarAutores faa = new FrmActualizarAutores();
        FrmMostrarAutor fma = new FrmMostrarAutor();
        //Menu Libros
        FrmLibros fl = new FrmLibros();
        FrmInsertarLibro fil = new FrmInsertarLibro();
        FrmEliminarLibro fel = new FrmEliminarLibro();
        FrmActualizacionLibro fal = new FrmActualizacionLibro();
        FrmMostrarLibros fml = new FrmMostrarLibros();
        //mostrarGeneral
        FrmMostrarGeneral fmg = new FrmMostrarGeneral();
        
        //daovo autor
        AutorVO avo = new AutorVO();
        AutorDAO adao = new AutorDAO();
        //daovo libro
        LibroVO lvo = new LibroVO();
        LibroDAO ldao = new LibroDAO();
        //inerr join
        AutorLibroVO alvo = new AutorLibroVO();
        AutorLibroDAO aldao = new AutorLibroDAO();
        
        //Insertar y menu principal
        ControladorInsertar cia = new ControladorInsertar(fa,fia, avo, adao, fl, fil, lvo, ldao);
        ControladorMenu cm =  new ControladorMenu(fa, fm, fl, fmg);
        ControladorMenuAutores cMa = new ControladorMenuAutores(fa, fia,fea,faa,fma);
        ControladorEliminar cme = new ControladorEliminar(fa, fea, avo, adao, fl, fel, lvo, ldao);
        ControladorActualizar ca = new ControladorActualizar(faa, fa, avo, adao,fl,fal,lvo,ldao);
        ControladorMostrar cmos = new ControladorMostrar(fma, fa, avo, adao,fl,fml,lvo,ldao);
        //Libros
        ControladorMenuLibros cml =  new ControladorMenuLibros(fl, fil,fel,fal,fml);
        //losdos
        ControladorMostrarTodo cmt = new ControladorMostrarTodo(fm, fmg, alvo, aldao);
        
        
        fm.setVisible(true);
        fm.setLocationRelativeTo(fm);
        fm.setResizable(true);
    }
    
}
