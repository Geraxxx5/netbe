package conectocompleto2022;

import conexion.Conector;
import controlador.ControladorInsertar;
import vista.FrmInserta;
import vista.FrmMenu;
import controlador.ControladorMenu;
import modelo.PaisDAO;
import modelo.PaisVO;

public class ConectoCompleto2022 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        //Vistas
        FrmMenu fm = new FrmMenu();
        FrmInserta fi = new FrmInserta();
        
        //Modelo
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        //Controlador

        ControladorMenu cm = new ControladorMenu(fm,fi);
        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        
        //Configuracion de pantalla
        fm.setVisible(true);
        fm.setLocationRelativeTo(fm);
        fm.setResizable(false);
        
    }
    
}
