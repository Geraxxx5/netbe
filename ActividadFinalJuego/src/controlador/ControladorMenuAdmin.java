package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmAdminActualizarUsu;
import vista.FrmAdminBorrarUsu;
import vista.FrmAdminMirarUsuario;
import vista.FrmAdminNuevoUsuario;
import vista.FrmAdministrador;

public class ControladorMenuAdmin implements ActionListener{
    
    FrmAdministrador vAdm = new FrmAdministrador();
    FrmAdminNuevoUsuario vAnu = new FrmAdminNuevoUsuario();
    FrmAdminActualizarUsu vAa = new FrmAdminActualizarUsu();
    FrmAdminBorrarUsu vAb = new FrmAdminBorrarUsu();
    FrmAdminMirarUsuario vAm = new FrmAdminMirarUsuario();
    
    public ControladorMenuAdmin(FrmAdministrador vAdm, FrmAdminNuevoUsuario vAnu, FrmAdminActualizarUsu vAa, FrmAdminBorrarUsu vAb, FrmAdminMirarUsuario vAm){
        this.vAdm = vAdm;
        this.vAnu = vAnu;
        this.vAa = vAa;
        this.vAb = vAb;
        this.vAm = vAm;
        
        this.vAdm.btnNuevoUsuario.addActionListener(this);
        this.vAdm.btnBorrarUsuario.addActionListener(this);
        this.vAdm.btnModificarUsuario.addActionListener(this);
        this.vAdm.btnMostrarUsuario.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAdm.btnNuevoUsuario){
            this.vAnu.setVisible(true);
        }
        if(e.getSource() == this.vAdm.btnBorrarUsuario){
            this.vAb.setVisible(true);
        }
        if(e.getSource() == this.vAdm.btnModificarUsuario){
            this.vAa.setVisible(true);
        }
        if(e.getSource() == this.vAdm.btnMostrarUsuario){
            this.vAm.setVisible(true);
        }
    }
    
}
