
package ejemplomvc;

import ejemplomvc.controlador.Controlador;
import ejemplomvc.modelo.ModeloLogico;
import ejemplomvc.vista.vista;

public class EjemploMVC {

    public static void main(String[] args) {
        vista vis = new vista();
        ModeloLogico modelo = new ModeloLogico();
        Controlador con = new Controlador(vis,modelo);
        vis.setVisible(true);

    }
    
}
