package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.EstadoVO;
import modelo.Extras;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdminNuevoUsuario;
import vista.FrmAdministrador;

public class ControladorInsertarUsuario implements ActionListener, WindowListener{
    
    FrmAdministrador vAdm = new FrmAdministrador();
    FrmAdminNuevoUsuario vAnu = new FrmAdminNuevoUsuario();
    EstadoVO evo = new EstadoVO();
    TipoUsuarioVO tuvo = new TipoUsuarioVO();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();

    public ControladorInsertarUsuario(FrmAdministrador vAdm, FrmAdminNuevoUsuario vAnu, EstadoVO evo, TipoUsuarioVO tuvo, UsuarioVO uvo){
        this.vAdm = vAdm;
        this.vAnu = vAnu;
        this.evo = evo;
        this.tuvo = tuvo;
        this.uvo = uvo;
        
        this.vAnu.addWindowListener(this);
        this.vAnu.btnCancelar.addActionListener(this);
        this.vAnu.btnIngresar.addActionListener(this);
    }
    
    private void llenarCombos(){
        this.vAnu.comboEstado.removeAllItems();
        this.vAnu.comboTipoUsuario.removeAllItems();
        for(EstadoVO evo: Extras.datosComboEstado()){
            this.vAnu.comboEstado.addItem(evo.getNombreEstado());
        }
        for(TipoUsuarioVO tuvo: Extras.datosComboTipoUsuario()){
            this.vAnu.comboTipoUsuario.addItem(tuvo.getNombreTipoUsuario());
        }
    }
    
    private void ingresarUsuario(){
        if((this.vAnu.txtNombreUsuario.getText() != "")&&(this.vAnu.txtApellidoUsuario.getText() != "")&&(this.vAnu.txtContra.getText() != "")&&(this.vAnu.txtEdadUsuario.getText() != "")&&(this.vAnu.txtUser.getText() != "")){
            this.uvo.setApellidoUsuario(this.vAnu.txtApellidoUsuario.getText());
            this.uvo.setEdadUsuario(Integer.parseInt(this.vAnu.txtEdadUsuario.getText()));
            this.uvo.setFkIdEstado(Extras.retornarIdEstado(String.valueOf(this.vAnu.comboEstado.getSelectedItem())));
            //System.out.println(Extras.retornarIdEstado(String.valueOf(this.vAnu.comboEstado.getSelectedItem())));
            this.uvo.setFkIdTipoUsuario(Extras.retornarIdTipoUsuario(String.valueOf(this.vAnu.comboTipoUsuario.getSelectedItem())));
            this.uvo.setNombreUsuario(this.vAnu.txtNombreUsuario.getText());
            this.uvo.setPassUsuario(this.vAnu.txtContra.getText());
            this.uvo.setUserUsuario(this.vAnu.txtUser.getText());
            if(this.udao.vereficarExistencia(uvo)){
                if(this.udao.ingresarUsuario(uvo)){
                    this.vAnu.jopMensaje.showMessageDialog(vAnu, "Se ingresaron Correctamente los datos");
                    this.vAnu.txtNombreUsuario.setText("");
                    this.vAnu.txtApellidoUsuario.setText("");
                    this.vAnu.txtContra.setText("");
                    this.vAnu.txtEdadUsuario.setText("");
                    this.vAnu.txtUser.setText("");
                }else{
                    this.vAnu.jopMensaje.showMessageDialog(vAnu, "Error, no se ingresaron correctamente los datos");
                }
            }else{
                this.vAnu.jopMensaje.showMessageDialog(vAnu, "Ya existe el User");
            }
        }else{
            this.vAnu.jopMensaje.showMessageDialog(vAnu, "Error Ingrese todos los datos");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAnu.btnCancelar){
            this.vAnu.dispose();
        }
        if(e.getSource() == this.vAnu.btnIngresar){
            this.ingresarUsuario();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.llenarCombos();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    
}
