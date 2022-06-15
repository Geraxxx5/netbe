package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Extras;
import vista.FrmAutores;
import vista.FrmLibros;
import vista.FrmMenuPrincipal;
import vista.FrmMostrarGeneral;

public class ControladorMenu implements ActionListener{

    FrmAutores mA = new FrmAutores();
    FrmMenuPrincipal mMp = new FrmMenuPrincipal();
    FrmLibros mL = new FrmLibros();
    FrmMostrarGeneral mMg = new FrmMostrarGeneral();
    
    public ControladorMenu(FrmAutores mA, FrmMenuPrincipal mMp,FrmLibros mL, FrmMostrarGeneral mMg){
        this.mA = mA;
        this.mMp = mMp;
        this.mL = mL;
        this.mMg = mMg;
        
        this.mMp.btnAutor.addActionListener(this);
        this.mMp.btnLibro.addActionListener(this);
        this.mMp.btnAutorLibro.addActionListener(this);
    }
    
    private void ingresoMenuLirbos(){
        boolean bandera = Extras.validarTablaVacia();
        if(bandera){
            this.mL.setVisible(true);
            mL.setLocationRelativeTo(mA);
            mL.setResizable(true);
        }else{
            this.mMp.jopMensajes.showMessageDialog(mMp, "No se puede entrar a esta seccion\nPrimero ingresar valores en Autor");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mMp.btnAutor){
            this.mA.setVisible(true);
            mA.setLocationRelativeTo(mA);
            mA.setResizable(true);
        }
        if(e.getSource() == this.mMp.btnLibro){
            this.ingresoMenuLirbos();
        }
        if(e.getSource() == this.mMp.btnAutorLibro){
            this.mMg.setVisible(true);
            mMg.setLocationRelativeTo(mA);
            mMg.setResizable(true);
        }
    }
    
}
