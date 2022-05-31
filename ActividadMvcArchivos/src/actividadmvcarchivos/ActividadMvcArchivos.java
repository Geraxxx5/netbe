
package actividadmvcarchivos;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.frmArchivos;


public class ActividadMvcArchivos {

    public static void main(String[] args) {
        
        frmArchivos frm = new frmArchivos();
        ModeloLogico modelo = new ModeloLogico();
        Controlador con = new Controlador(frm,modelo);
        frm.setVisible(true);
    }
    
}
