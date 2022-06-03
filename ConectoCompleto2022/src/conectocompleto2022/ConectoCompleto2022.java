package conectocompleto2022;

import conexion.Conector;
import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import vista.FrmInserta;
import vista.FrmMenu;
import controlador.ControladorMenu;
import controlador.ControladorMostrar;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmMostrarPais;

public class ConectoCompleto2022 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        //Vistas
        FrmMenu fm = new FrmMenu();
        FrmInserta fi = new FrmInserta();
        FrmMostrarPais fmp = new FrmMostrarPais();
        FrmEliminar fme = new FrmEliminar();
        FrmActualizar fac = new FrmActualizar();
        
        //Modelo
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        //Controlador

        ControladorMenu cm = new ControladorMenu(fm,fi,fmp,fme,fac);
        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        ControladorMostrar cmo = new ControladorMostrar(fmp, pvo, pdao);
        ControladorEliminar ce = new ControladorEliminar(fme, pvo, pdao);
        ControladorActualizar cac = new ControladorActualizar(fac, pvo, pdao);
        
        //Configuracion de pantalla
        fm.setVisible(true);
        fm.setLocationRelativeTo(fm);
        fm.setResizable(false);
        
    }
    
}
