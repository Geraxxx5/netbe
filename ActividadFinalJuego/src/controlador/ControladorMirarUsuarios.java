package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdminMirarUsuario;
import vista.FrmAdministrador;

public class ControladorMirarUsuarios implements WindowListener, ActionListener{

    FrmAdminMirarUsuario vAmu = new FrmAdminMirarUsuario();
    FrmAdministrador vAmin = new FrmAdministrador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    
    
    public ControladorMirarUsuarios(FrmAdminMirarUsuario vAmu, FrmAdministrador vAmin, UsuarioVO uvo, UsuarioDAO udao){
        this.vAmu = vAmu;
        this.vAmin = vAmin;
        this.udao = udao;
        this.uvo = uvo;
        
        this.vAmu.addWindowListener(this);
        this.vAmu.btnPdf.addActionListener(this);
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
        
        this.vAmu.tblUsuarios.setModel(m);
        
        for(UsuarioVO uvo: udao.datosTabla()){
            String estado = Extras.retornarEstado(uvo.getFkIdEstado());
            String tipoUsuario = Extras.retornarTipoUsuario(uvo.getFkIdTipoUsuario());
            m.addRow(new Object[]{uvo.getIdUsuario(), uvo.getNombreUsuario(), uvo.getApellidoUsuario(), uvo.getEdadUsuario(), uvo.getUserUsuario(),estado,tipoUsuario});         
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAmu.btnPdf){
            udao.reporte();
            udao.jv.setDefaultCloseOperation(vAmu.DISPOSE_ON_CLOSE);
            udao.jv.setVisible(true);
        }
    }
    
}
