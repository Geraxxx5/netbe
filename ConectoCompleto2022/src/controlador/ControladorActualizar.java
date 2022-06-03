package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Extras;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;


public class ControladorActualizar implements ActionListener,WindowListener,MouseListener {

    FrmActualizar vMa = new FrmActualizar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorActualizar(FrmActualizar vMa, PaisVO pvo,PaisDAO pdao){
        this.vMa = vMa;
        this.pvo = pvo;
        this.pdao = pdao;
        
        
        this.vMa.btnRegresar.addActionListener(this);
        this.vMa.btnActualizar.addActionListener(this);
        this.vMa.tblActualizar.addMouseListener(this);
        this.vMa.addWindowListener(this);
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
          
        this.vMa.tblActualizar.setModel(m);
        TableColumn cCero = this.vMa.tblActualizar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.vMa.tblActualizar.getColumnModel().getColumn(1);
        cCero.setMaxWidth(180);
    }
    
    private void visual(){
        int row = this.vMa.tblActualizar.getSelectedRow();
        this.vMa.txtIdPais.setText(String.valueOf(this.vMa.tblActualizar.getValueAt(row, 0)));
        this.vMa.txtNoPais.setText(String.valueOf(this.vMa.tblActualizar.getValueAt(row, 1)));
        this.vMa.txtCapPais.setText(String.valueOf(this.vMa.tblActualizar.getValueAt(row, 2)));
        this.vMa.txtPoblacion.setText(String.valueOf(this.vMa.tblActualizar.getValueAt(row, 3)));
    }
    
    private void Actualizar(){
        if((vMa.txtIdPais.getText() != "")&&(vMa.txtNoPais.getText() != "")&&(vMa.txtCapPais.getText() != "")&&(vMa.txtPoblacion.getText() != "")){
            try {
                this.pvo.setIdPais(Integer.parseInt(this.vMa.txtIdPais.getText()));
                this.pvo.setNombrePais(this.vMa.txtNoPais.getText());
                this.pvo.setCapitalPais(this.vMa.txtCapPais.getText());
                this.pvo.setPoblacionPais(Long.parseLong(this.vMa.txtPoblacion.getText()));
                this.pvo.setFechaActPais(Date.valueOf(Extras.fechaHoy()));
                if (this.pdao.actualizar(pvo) == true){
                    this.vMa.jopMensaje.showMessageDialog(vMa, "Se han actualizado correctamente los datos");
                    this.vMa.txtIdPais.setText("");
                    this.vMa.txtNoPais.setText("");
                    this.vMa.txtCapPais.setText("");
                    this.vMa.txtPoblacion.setText("");
                    this.mostrar();
                }else{
                    this.vMa.jopMensaje.showMessageDialog(vMa, "Error al actualizar los datos");
                    this.vMa.txtIdPais.setText("");
                    this.vMa.txtNoPais.setText("");
                    this.vMa.txtCapPais.setText("");
                    this.vMa.txtPoblacion.setText("");
                }
            } catch (Exception e) {
                this.vMa.jopMensaje.showMessageDialog(vMa, "Introduzca correcamente los datos");
            }
        }else{
            this.vMa.jopMensaje.showMessageDialog(vMa, "Hay datos faltantes para poder actualizar");
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMa.btnRegresar){
            this.vMa.dispose();
        }
        if(e.getSource() == this.vMa.btnActualizar){
            this.Actualizar();
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
        this.visual();
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
