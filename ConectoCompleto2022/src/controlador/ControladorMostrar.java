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
import vista.FrmMostrarPais;

public class ControladorMostrar implements ActionListener,WindowListener, MouseListener{

    FrmMostrarPais vMo = new FrmMostrarPais();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorMostrar(FrmMostrarPais vMo, PaisVO pvo, PaisDAO pdao){
        
        this.vMo = vMo;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vMo.btnCancelarMostrar.addActionListener(this);
        vMo.lblReporte.addMouseListener(this);
        vMo.addWindowListener(this);
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("id del pais");
        m.addColumn("Nombre del Pais");
        m.addColumn("Capital del Pais");
        m.addColumn("Poblacion del Pais");
        
        for(PaisVO pvo: pdao.consultar()){
            m.addRow(new Object[]{pvo.getIdPais(),pvo.getNombrePais(),pvo.getCapitalPais(),pvo.getPoblacionPais()});
        }
        
        
        vMo.tblMostrarPais.setModel(m);
        TableColumn cCero = vMo.tblMostrarPais.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = vMo.tblMostrarPais.getColumnModel().getColumn(1);
        cCero.setMaxWidth(180);

    }
    
    private void reporte(){
        pdao.reporte();
        pdao.jv.setDefaultCloseOperation(vMo.DISPOSE_ON_CLOSE);
        pdao.jv.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vMo.btnCancelarMostrar){
            vMo.dispose();
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
        if(e.getSource() ==  vMo.lblReporte){
            if(e.getClickCount() == 2){
                this.reporte();
            }
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
