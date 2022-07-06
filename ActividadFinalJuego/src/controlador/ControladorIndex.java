package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioScoreDAO;
import modelo.UsuarioScoreVO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmAvanzado;
import vista.FrmIndex;
import vista.FrmIntermedio;
import vista.FrmModificarUsuario;
import vista.FrmPrincipiante;

public class ControladorIndex implements ActionListener{

    //ventanas
    FrmIndex vInd = new FrmIndex();
    FrmAdministrador vAd = new FrmAdministrador();

    
    FrmPrincipiante vPrin = new FrmPrincipiante();
    
    FrmIntermedio vInter = new FrmIntermedio();
    
    FrmAvanzado vAvanzado = new FrmAvanzado();
    
    FrmModificarUsuario vMus = new FrmModificarUsuario();
    //daovo
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    
    UsuarioScoreVO usvo = new UsuarioScoreVO();
    UsuarioScoreDAO usdao = new UsuarioScoreDAO();
    
    private String usuario;
    
    public ControladorIndex(FrmModificarUsuario vMus, FrmAvanzado vAvanzado, FrmIntermedio vInter, FrmPrincipiante vPrin, FrmIndex vInd,FrmAdministrador vAd, UsuarioVO uvo, UsuarioDAO udao, UsuarioScoreVO usvo, UsuarioScoreDAO usdao){
        this.vInd = vInd;
        this.vAd = vAd;
        this.uvo = uvo;
        this.udao = udao;
        this.vPrin = vPrin;
        this.usvo = usvo;
        this.usdao = usdao;
        this.vInter = vInter;
        this.vAvanzado = vAvanzado;
        this.vMus = vMus;
        
        this.vInd.btnIngresar.addActionListener(this);
    }
    
    private void ingresar(){
        if((this.vInd.txtPass.getText() != "")&&(this.vInd.txtUsuario.getText() != "")){
            this.uvo.setPassUsuario(this.vInd.txtPass.getText());
            this.uvo.setUserUsuario(this.vInd.txtUsuario.getText());
            int rol = this.udao.verificacion(uvo);
            switch (rol){
                case -1:
                    this.vInd.jopMensaje.showMessageDialog(vInd, "Tu usuario esta desactivado comunicate con un Administradot");
                    break;
                case 0:
                    this.vInd.jopMensaje.showMessageDialog(vInd, "Usuario o Contraseña incorrectas");
                    break;
                case 1:
                    this.vInd.dispose();
                    this.vAd.setVisible(true);
                    this.usuario = this.vInd.txtUsuario.getText();
                    break;
                case 2:
                    this.usuario = this.vInd.txtUsuario.getText();
                    ControladorPrincipiante cpri = new ControladorPrincipiante(vMus, vInd, vAvanzado, usuario, vPrin, usvo, usdao, vInter);
                    this.vInd.dispose();
                    this.vPrin.setVisible(true);
                    break;
                case 3:
                    this.usuario = this.usuario = this.vInd.txtUsuario.getText();
                    ControladorIntermedio cinter = new ControladorIntermedio(vMus, vInd, vPrin, vAvanzado, usuario, vInter, usvo, usdao);
                    this.vInd.dispose();
                    this.vInter.setVisible(true);
                    break;
                case 4:
                    this.usuario = this.usuario = this.vInd.txtUsuario.getText();
                    ControladorAvanzado cavanza = new ControladorAvanzado(vMus, vInd, vInter, vPrin, usuario, vAvanzado, usvo, usdao);
                    this.vInd.dispose();
                    this.vAvanzado.setVisible(true);
                    break;
            }
        }else{
            this.vInd.jopMensaje.showMessageDialog(vInd, "No puede dejar vacios los compos");
        }
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vInd.btnIngresar){
            this.ingresar();
        }
    }
    
}
