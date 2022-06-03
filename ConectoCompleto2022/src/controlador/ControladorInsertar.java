package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import modelo.PaisDAO;
import modelo.Extras;
import modelo.PaisVO;
import vista.FrmInserta;

public class ControladorInsertar implements ActionListener {

    FrmInserta vIn = new FrmInserta();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorInsertar(FrmInserta vIn, PaisVO pvo, PaisDAO pdao){
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;

        
        vIn.btnNuevoReg.addActionListener(this);
        vIn.btnNuevoCancelar.addActionListener(this);
       
    }
    
    private void registrarPais(){
        try {
            this.pvo.setNombrePais(this.vIn.txtNombrePais.getText());
            this.pvo.setCapitalPais(this.vIn.txtCapitalPais.getText());
            this.pvo.setPoblacionPais(Long.parseLong(this.vIn.txtPoblacionPais.getText()));
            this.pvo.setFechaIngPais(Date.valueOf(Extras.fechaHoy()));
            //this.pdao.insertar(pvo);
            if (pdao.insertar(pvo) == true){
                vIn.jopMensaje.showMessageDialog(vIn, "Datos Insertados Correctamente");
                this.vIn.txtNombrePais.setText("");
                this.vIn.txtCapitalPais.setText("");
                this.vIn.txtPoblacionPais.setText("");
            }
            else{
                vIn.jopMensaje.showMessageDialog(vIn, "Error, Datos no Registrados");
                this.vIn.txtNombrePais.setText("");
                this.vIn.txtCapitalPais.setText("");
                this.vIn.txtPoblacionPais.setText("");
            }
        } catch (Exception e) {
            vIn.jopMensaje.showMessageDialog(vIn, "Error, Ingrese Correctamente los datos");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vIn.btnNuevoReg){
            if(!this.vIn.txtNombrePais.getText().equals("")&&!this.vIn.txtCapitalPais.getText().equals("")&&!this.vIn.txtPoblacionPais.getText().equals("")){
                this.registrarPais();
            }
            else{
                this.vIn.jopMensaje.showMessageDialog(vIn, "Debe de llenar todos los datos");
            }
        }
        if (e.getSource() == this.vIn.btnNuevoCancelar){
            this.vIn.dispose();
        }
        
    }
    
}
