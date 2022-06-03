package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmEliminar;

public class ControladorEliminar implements ActionListener, WindowListener, MouseListener {

    FrmEliminar vEli = new FrmEliminar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    
    public ControladorEliminar(FrmEliminar vEli, PaisVO pvo, PaisDAO pdao){
        this.vEli = vEli;
        this.pvo = pvo;
        this.pdao = pdao;
        
        this.vEli.addWindowListener(this);
        this.vEli.tblModifica.addMouseListener(this);
        this.vEli.btnRegresa.addActionListener(this);
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("id del pais");
        m.addColumn("Nombre del Pais");
        m.addColumn("Capital del Pais");
        m.addColumn("Poblacion del Pais");
        
        for(PaisVO pvo: pdao.consultar()){
            m.addRow(new Object[]{pvo.getIdPais(),pvo.getNombrePais(),pvo.getCapitalPais(),pvo.getPoblacionPais()});
        }
          
        this.vEli.tblModifica.setModel(m);
        TableColumn cCero = this.vEli.tblModifica.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.vEli.tblModifica.getColumnModel().getColumn(1);
        cCero.setMaxWidth(180);

    }
    
    private void seleccion(){
        int row = this.vEli.tblModifica.getSelectedRow();
        int idPais = (int)this.vEli.tblModifica.getValueAt(row, 0);
        String nombrePais = String.valueOf(this.vEli.tblModifica.getValueAt(row, 1));
        int r = this.vEli.jopMensaje.showConfirmDialog(this.vEli,"Estas seguro de borrar:\n id: "+idPais+" Pais: "+nombrePais);
        if(r == this.vEli.jopMensaje.YES_OPTION){
            this.pvo.setIdPais(idPais);
            if (this.pdao.eliminar(pvo) == true){
                this.vEli.jopMensaje.showMessageDialog(vEli, "Datos Eliminados");
                this.mostrar();
            }else{
                this.vEli.jopMensaje.showMessageDialog(vEli, "Error al eliminar los datos");
            }
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vEli.btnRegresa){
            this.vEli.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
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
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.seleccion();   
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
