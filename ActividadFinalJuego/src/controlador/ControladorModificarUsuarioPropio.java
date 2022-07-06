package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioScoreDAO;
import modelo.UsuarioScoreVO;
import vista.FrmIndex;
import vista.FrmModificarUsuario;

public class ControladorModificarUsuarioPropio implements ActionListener{

    UsuarioScoreVO usvo = new UsuarioScoreVO();
    UsuarioScoreDAO usdao = new UsuarioScoreDAO();
    
    FrmIndex vInde = new FrmIndex();
    FrmModificarUsuario vMoU = new FrmModificarUsuario();
    
    public ControladorModificarUsuarioPropio(FrmModificarUsuario vMoU, FrmIndex vInde, UsuarioScoreVO usvo, UsuarioScoreDAO usdao){
        this.usvo = usvo;
        this.usdao = usdao;
        this.vInde = vInde;
        this.vMoU = vMoU;
        
        this.vMoU.btnModificar.addActionListener(this);
        this.vMoU.btnCancelar.addActionListener(this);
        this.colocarDatos();
    }
    
    private void colocarDatos(){
        this.vMoU.txtApellidoUsuario.setText(this.usvo.getApellidoUsuario());
        this.vMoU.txtContra.setText(this.usvo.getPassUsuario());
        this.vMoU.txtEdadUsuario.setText(String.valueOf(this.usvo.getEdadUsuario()));
        this.vMoU.txtIdUsuario.setText(String.valueOf(this.usvo.getIdUsuario()));
        this.vMoU.txtNombreUsuario.setText(this.usvo.getNombreUsuario());
        this.vMoU.txtUser.setText(this.usvo.getUserUsuario());
    }
    
    private void modificar(){
        try {
            if((this.vMoU.txtApellidoUsuario.getText() != "")&&(this.vMoU.txtEdadUsuario.getText() != "")&&(this.vMoU.txtIdUsuario.getText() != "")&&(this.vMoU.txtEdadUsuario.getText() != "")&&(this.vMoU.txtContra.getText() != "")&&(this.vMoU.txtUser.getText() != "")){
                this.usvo.setApellidoUsuario(String.valueOf(this.vMoU.txtApellidoUsuario.getText()));
                this.usvo.setEdadUsuario(Integer.parseInt(this.vMoU.txtEdadUsuario.getText()));
                this.usvo.setIdUsuario(Integer.parseInt(this.vMoU.txtIdUsuario.getText()));
                this.usvo.setNombreUsuario(String.valueOf(this.vMoU.txtEdadUsuario.getText()));
                this.usvo.setPassUsuario(String.valueOf(this.vMoU.txtContra.getText()));
                this.usvo.setUserUsuario(String.valueOf(this.vMoU.txtUser.getText()));
                if(this.usdao.modificarUsuario(usvo)){
                    this.vMoU.jopMensaje.showMessageDialog(vInde, "Se modificaron los datos");
                    this.vMoU.dispose();
                    this.vInde.setVisible(true);
                }
            }else{
                this.vMoU.jopMensaje.showMessageDialog(vInde, "Asegurese de ingresar Todos los datos");
            }
        } catch (Exception e) {
            this.vMoU.jopMensaje.showMessageDialog(vInde, "Asegurese de ingresar bien los datos");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vMoU.btnCancelar == e.getSource()){
            this.vMoU.dispose();
            this.vInde.setVisible(true);
        }
        if(e.getSource() == this.vMoU.btnModificar){
            this.modificar();
        }
    }
    
}
