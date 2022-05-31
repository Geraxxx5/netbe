
package ejemplomvc.controlador;

import ejemplomvc.modelo.ModeloLogico;
import ejemplomvc.vista.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
    
  
    vista vis = new vista();
    ModeloLogico modelo = new ModeloLogico();

    public Controlador(vista vis, ModeloLogico modelo){

        this.vis = vis;
        this.modelo = modelo;

        this.vis.btnTraduci.addActionListener(this);
    }

    private void tradu(){
        this.modelo.setRes(String.valueOf(this.vis.Opciones.getSelectedItem()));
        this.vis.resultado.showMessageDialog(this.vis,this.modelo.palabra());
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.vis.btnTraduci){
            this.tradu(); 
        }
    }


}
