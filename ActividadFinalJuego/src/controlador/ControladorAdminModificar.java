package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoVO;
import modelo.Extras;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdminActualizarUsu;
import vista.FrmAdminBorrarUsu;
import vista.FrmAdministrador;


public class ControladorAdminModificar implements ActionListener, WindowListener, MouseListener{

    FrmAdministrador vAmd = new FrmAdministrador();
    FrmAdminActualizarUsu vAau = new FrmAdminActualizarUsu();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    
    
    public ControladorAdminModificar(FrmAdministrador vAmd, FrmAdminActualizarUsu vAau, UsuarioVO uvo, UsuarioDAO udao){
        this.vAmd = vAmd;
        this.vAau = vAau;
        
        this.uvo = uvo;
        this.udao = udao;
        
        this.vAau.btnModificar.addActionListener(this);
        this.vAau.btnRegresar.addActionListener(this);
        
        this.vAau.tblModificarUs.addMouseListener(this);
        
        this.vAau.addWindowListener(this);
    }
    
    private void llenarTabla(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id Usuario");
        m.addColumn("Nombre Usuario");
        m.addColumn("Apellido Usuario");
        m.addColumn("Edad Usuario");
        m.addColumn("User");
        m.addColumn("Estado");
        m.addColumn("Tipo de Usuario");
        
        this.vAau.tblModificarUs.setModel(m);
        
        for(UsuarioVO uvo: udao.datosTabla()){
            String estado = Extras.retornarEstado(uvo.getFkIdEstado());
            String tipoUsuario = Extras.retornarTipoUsuario(uvo.getFkIdTipoUsuario());
            m.addRow(new Object[]{uvo.getIdUsuario(), uvo.getNombreUsuario(), uvo.getApellidoUsuario(), uvo.getEdadUsuario(), uvo.getUserUsuario(),estado,tipoUsuario});         
        }
    }
    
    private void modificar(){
        try {
            if((this.vAau.txtApellidoUsuario.getText() != "")&&(this.vAau.txtEdadUsuario.getText() != "")&&(this.vAau.txtIdUsuario.getText() != "")&&(this.vAau.txtNombreUsuario.getText() != "")&&(this.vAau.txtUser.getText() != "")){
                uvo.setApellidoUsuario(this.vAau.txtApellidoUsuario.getText());
                uvo.setEdadUsuario(Integer.parseInt(this.vAau.txtEdadUsuario.getText()));
                uvo.setFkIdEstado(Extras.retornarIdEstado(String.valueOf(this.vAau.comboEstado.getSelectedItem())));
                uvo.setFkIdTipoUsuario(Extras.retornarIdTipoUsuario(String.valueOf(this.vAau.comboTipoUsuario.getSelectedItem())));
                uvo.setIdUsuario(Integer.parseInt(this.vAau.txtIdUsuario.getText()));
                uvo.setNombreUsuario(this.vAau.txtNombreUsuario.getText());
                uvo.setUserUsuario(this.vAau.txtUser.getText());
                if(this.udao.actualizar(uvo)){
                    this.vAau.jopMensaje.showMessageDialog(vAau, "Se modificaron los datos correctamente");
                    this.vAau.txtApellidoUsuario.setText("");
                    this.vAau.txtEdadUsuario.setText("");
                    this.vAau.comboEstado.removeAllItems();
                    this.vAau.comboTipoUsuario.removeAllItems();
                    this.vAau.txtIdUsuario.setText("");
                    this.vAau.txtNombreUsuario.setText("");
                    this.vAau.txtUser.setText("");
                    this.llenarTabla();
                }else{
                    this.vAau.jopMensaje.showMessageDialog(vAau, "Los datos no se pudieron mudificar");
                    this.vAau.txtApellidoUsuario.setText("");
                    this.vAau.txtEdadUsuario.setText("");
                    this.vAau.comboEstado.removeAllItems();
                    this.vAau.comboTipoUsuario.removeAllItems();
                    this.vAau.txtIdUsuario.setText("");
                    this.vAau.txtNombreUsuario.setText("");
                    this.vAau.txtUser.setText("");
                }
            }else{
                this.vAau.jopMensaje.showMessageDialog(vAau, "Error, ingrese todos los campos");
            }
        } catch (Exception e) {
            this.vAau.jopMensaje.showMessageDialog(vAau, "Error, ingrese correctamente los datos");
        }
    }
    
    private void llenarDatos(){
        int row = this.vAau.tblModificarUs.getSelectedRow();
        this.vAau.txtIdUsuario.setText(String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 0)));
        this.vAau.txtNombreUsuario.setText(String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 1)));
        this.vAau.txtApellidoUsuario.setText(String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 2)));
        this.vAau.txtEdadUsuario.setText(String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 3)));
        this.vAau.txtUser.setText(String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 4)));
        
        this.vAau.comboEstado.removeAllItems();
        this.vAau.comboTipoUsuario.removeAllItems();
        
        String estado = String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 5));
        this.vAau.comboEstado.addItem(estado);
        for(EstadoVO evo: Extras.datosComboEstado()){
            if(!((estado).equals(evo.getNombreEstado()))){
                this.vAau.comboEstado.addItem(evo.getNombreEstado());
            }
        }
        String tipoUsuario = String.valueOf(this.vAau.tblModificarUs.getValueAt(row, 6));
        this.vAau.comboTipoUsuario.addItem(tipoUsuario);
        for(TipoUsuarioVO tuvo:Extras.datosComboTipoUsuario()){
            if(!((tipoUsuario).equals(tuvo.getNombreTipoUsuario()))){
                this.vAau.comboTipoUsuario.addItem(tuvo.getNombreTipoUsuario());
            }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAau.btnRegresar){
            this.vAau.dispose();
        }
        if(e.getSource() == this.vAau.btnModificar){
            this.modificar();
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
        this.llenarTabla();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            this.llenarDatos();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
