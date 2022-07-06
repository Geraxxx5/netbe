package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdminBorrarUsu;
import vista.FrmAdministrador;

public class ControladorBorrarUsuario implements ActionListener, WindowListener, MouseListener{

    FrmAdminBorrarUsu vAbu = new FrmAdminBorrarUsu();
    FrmAdministrador vAdmin = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    
    public ControladorBorrarUsuario(FrmAdminBorrarUsu vAbu, FrmAdministrador vAdmin, UsuarioVO uvo, UsuarioDAO udao){
        this.vAbu = vAbu;
        this.vAdmin = vAdmin;
        this.uvo = uvo;
        this.udao = udao;
        
        this.vAbu.addWindowListener(this);
        this.vAbu.btnRegresar.addActionListener(this);
        this.vAbu.tblBorrarUsuario.addMouseListener(this);
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
        
        this.vAbu.tblBorrarUsuario.setModel(m);
        
        for(UsuarioVO uvo: udao.datosTabla()){
            if(uvo.getFkIdEstado() != 0){
                String estado = Extras.retornarEstado(uvo.getFkIdEstado());
                String tipoUsuario = Extras.retornarTipoUsuario(uvo.getFkIdTipoUsuario());
                m.addRow(new Object[]{uvo.getIdUsuario(), uvo.getNombreUsuario(), uvo.getApellidoUsuario(), uvo.getEdadUsuario(), uvo.getUserUsuario(),estado,tipoUsuario});
            }
        }
    }
    
    private void borrarSeleccion(){
        int row = this.vAbu.tblBorrarUsuario.getSelectedRow();
        int idUsuario = (int)this.vAbu.tblBorrarUsuario.getValueAt(row, 0);
        String usuario = String.valueOf(this.vAbu.tblBorrarUsuario.getValueAt(row, 4));
        int r = this.vAbu.jopMensaje.showConfirmDialog(vAbu, "Estas seguro de borrar: \nid Usuario: "+idUsuario+" User: "+usuario);
        if(r == this.vAbu.jopMensaje.YES_OPTION){
            this.uvo.setIdUsuario(idUsuario);
            if(this.udao.borrar(uvo)){
                this.vAbu.jopMensaje.showMessageDialog(vAbu, "Los datos se borraron correctamente");
                this.llenarTabla();
            }else{
                this.vAbu.jopMensaje.showMessageDialog(vAbu, "Error, no se borraron correctamente los datos");
            }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAbu.btnRegresar){
            this.vAbu.dispose();
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
            this.borrarSeleccion();
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
