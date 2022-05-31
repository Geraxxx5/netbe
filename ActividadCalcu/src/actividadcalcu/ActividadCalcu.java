
package actividadcalcu;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmCalcu;

public class ActividadCalcu {


    public static void main(String[] args) {
        // TODO code application logic here
        FrmCalcu vista = new FrmCalcu();
        ModeloLogico modelo = new ModeloLogico();
        Controlador c = new Controlador(vista,modelo);
        
        vista.setVisible(true);
    }
    
}
