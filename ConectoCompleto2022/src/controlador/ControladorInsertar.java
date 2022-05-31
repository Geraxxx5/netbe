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
        System.out.println("HolaaEntro1");
        
        vIn.btnNuevoReg.addActionListener(this);
        vIn.btnNuevoCancelar.addActionListener(this);
        
        vIn.btnNuevoReg.addActionListener(this);
        vIn.btnNuevoCancelar.addActionListener(this);
        System.out.println("Paso de aqui");
    }
    
    private void registrarPais(){
        this.pvo.setNombrePais(this.vIn.txtNombrePais.getText());
        this.pvo.setCapitalPais(this.vIn.txtCapitalPais.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vIn.txtPoblacionPais.getText()));
        this.pvo.setFechaIngPais(Date.valueOf(Extras.fechaHoy()));
        this.pdao.insertar(pvo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaaaEntro2");
        if (e.getSource() == this.vIn.btnNuevoCancelar){
            System.out.println("raro");
            this.registrarPais();
        }
        if (e.getSource() == this.vIn.btnNuevoCancelar){
            this.vIn.dispose();
        }
        //if(e.getSource() == this.vIn.btnRegistrarPais){
        //    System.out.println("Holaa");
        //    this.registrarPais();
        //}
    }
    
}
