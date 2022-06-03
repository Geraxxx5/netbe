package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInserta;
import vista.FrmMenu;
import vista.FrmMostrarPais;

public class ControladorMenu implements ActionListener {
    
    FrmMenu vMe  = new FrmMenu();
    FrmInserta vIn = new FrmInserta();
    FrmMostrarPais vMp = new FrmMostrarPais();
    FrmEliminar vMl = new FrmEliminar();
    FrmActualizar vAc = new FrmActualizar();
    
    public ControladorMenu(FrmMenu vMe, FrmInserta vIn, FrmMostrarPais vMp, FrmEliminar vMl, FrmActualizar vAc){
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMp = vMp;
        this.vMl = vMl;
        this.vAc = vAc;
        
        vMe.btnIsertar.addActionListener(this);
        vMe.btnMostrar.addActionListener(this);
        vMe.btnEliminar.addActionListener(this);
        vMe.btnActualizar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vMe.btnIsertar){
            this.vIn.setVisible(true);
            this.vIn.setLocationRelativeTo(vMe);
            this.vIn.setResizable(false);
        }
        if (e.getSource() == this.vMe.btnMostrar){
            this.vMp.setVisible(true);
            this.vMp.setLocationRelativeTo(vMe);
            this.vMp.setResizable(false);
        }
        if(e.getSource() == this.vMe.btnEliminar){
            this.vMl.setVisible(true);
            this.vMl.setLocationRelativeTo(vMe);
            this.vMl.setResizable(false);
        }
        if(e.getSource() == this.vMe.btnActualizar){
            this.vAc.setVisible(true);
            this.vAc.setLocationRelativeTo(vMe);
            this.vAc.setResizable(false);
        }
    }
    
}
