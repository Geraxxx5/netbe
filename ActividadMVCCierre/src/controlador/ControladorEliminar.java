package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Extras;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmAutores;
import vista.FrmEliminarAutor;
import vista.FrmEliminarLibro;
import vista.FrmLibros;

public class ControladorEliminar implements ActionListener,WindowListener,MouseListener{

    FrmAutores mA = new FrmAutores();
    FrmEliminarAutor mEa = new FrmEliminarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    //Libro
    FrmLibros mL = new FrmLibros();
    FrmEliminarLibro mEl = new FrmEliminarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    public ControladorEliminar(FrmAutores mA, FrmEliminarAutor mEa, AutorVO avo, AutorDAO adao, FrmLibros mL, FrmEliminarLibro mEl, LibroVO lvo, LibroDAO ldao){
        this.mA = mA;
        this.mEa = mEa;
        this.avo = avo;
        this.adao = adao;
        //Libro
        this.mL = mL;
        this.mEl = mEl;
        this.lvo = lvo;
        this.ldao = ldao;
        
        this.mEa.btnRegresar.addActionListener(this);
        this.mEa.addWindowListener(this);
        this.mEa.tblEliminarAutor.addMouseListener(this);
        //Libros
        this.mEl.tblEliminarLibro.addMouseListener(this);
        this.mEl.btnRegresar.addActionListener(this);
        this.mEl.addWindowListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mEa.btnRegresar){
            this.mEa.dispose();
            this.mA.setVisible(true);
        }
        if(e.getSource() == this.mEl.btnRegresar){
            this.mEl.dispose();
            this.mL.setVisible(true);
        }
    }
    
    private void eliminarAutor(){
        int row = this.mEa.tblEliminarAutor.getSelectedRow();
        int idAutor = (int)this.mEa.tblEliminarAutor.getValueAt(row, 0);
        boolean bandera = Extras.validarEliminar(idAutor);
        if(!bandera){
            String seudonimoAutor = String.valueOf(this.mEa.tblEliminarAutor.getValueAt(row, 2));
            int r = this.mEa.jopMensaje.showConfirmDialog(this.mEa,"Estas seguro de borrar:\n id: "+idAutor+" Autor: "+seudonimoAutor);
            if(r == this.mEa.jopMensaje.YES_OPTION){
                this.avo.setIdAutor(idAutor);
                if (this.adao.eliminarAutor(avo) == true){
                    this.mEa.jopMensaje.showMessageDialog(mEa, "Datos Eliminados");
                    this.mostrarAutor();
                }else{
                    this.mEa.jopMensaje.showMessageDialog(mEa, "Error al eliminar los datos");
                }
            }
        }else{
            this.mEa.jopMensaje.showMessageDialog(mEa, "Error, no se puede eliminar este autor.\nPrimero elimine los libros al que este relacionado este autor");
        }
    }
    
    private void eliminarLibro(){
        int row = this.mEl.tblEliminarLibro.getSelectedRow();
        int idLibro = (int)this.mEl.tblEliminarLibro.getValueAt(row, 0);
        String nombreLibro = String.valueOf(this.mEl.tblEliminarLibro.getValueAt(row, 2));
        int r = this.mEl.jopMensaje.showConfirmDialog(this.mEl,"Estas seguro de borrar:\n id: "+idLibro+" Nombre del Libro: "+nombreLibro);
        if(r == this.mEl.jopMensaje.YES_OPTION){
            this.lvo.setIdLibro(idLibro);
            if (this.ldao.eliminarLibro(lvo) == true){
                this.mEl.jopMensaje.showMessageDialog(mEa, "Datos Eliminados");
                this.mostrarLibro();
            }else{
                this.mEl.jopMensaje.showMessageDialog(mEa, "Error al eliminar los datos");
            }
        }
    }
    
    private void mostrarLibro(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("id del Libro");
        m.addColumn("Autor");
        m.addColumn("Nombre del Libro");
        m.addColumn("Fecha de Publicacion del Libro");
        m.addColumn("Numero de paginas del libro");
        m.addColumn("Genero Principal del libro");
        
        for(LibroVO lvo: ldao.consultarLibro()){
            String Seudonimo = Extras.retornarSeudonimo(lvo.getIdAutorFk());
            m.addRow(new Object[]{lvo.getIdLibro(),Seudonimo,lvo.getNombreLibro(),lvo.getFechaPublicacionLibro(),lvo.getNumeroPaginasLibro(),lvo.getGeneroPrincipalLibro()});
        }
          
        this.mEl.tblEliminarLibro.setModel(m);
        TableColumn cCero = this.mEl.tblEliminarLibro.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.mEl.tblEliminarLibro.getColumnModel().getColumn(1);
        cCero.setMaxWidth(75);
        //aaaa
        TableColumn cDos = this.mEl.tblEliminarLibro.getColumnModel().getColumn(2);
        cCero.setMaxWidth(250);
    }
    
    private void mostrarAutor(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("id del Autor");
        m.addColumn("Nombre del Autor");
        m.addColumn("Seudonimo del Autor");
        m.addColumn("Edad del Autor");
        m.addColumn("Genero del Autor");
        
        for(AutorVO avo: adao.consultarAutor()){
            m.addRow(new Object[]{avo.getIdAutor(),avo.getNombreAutor(),avo.getSeudonimoAutor(),avo.getEdadAutor(),avo.getGeneroAutor()});
        }
          
        this.mEa.tblEliminarAutor.setModel(m);
        TableColumn cCero = this.mEa.tblEliminarAutor.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.mEa.tblEliminarAutor.getColumnModel().getColumn(1);
        cCero.setMaxWidth(180);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if(e.getSource() == this.mEa){
            this.mostrarAutor();
        }
        if(e.getSource() == this.mEl){
            this.mostrarLibro();
        }
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
        if(e.getSource() == this.mEa){
            this.mostrarAutor();
        }
        if(e.getSource() == this.mEl){
            this.mostrarLibro();
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.mEa.tblEliminarAutor){
            if(e.getClickCount() == 2){
                this.eliminarAutor();
            }
        }
        if(e.getSource() == this.mEl.tblEliminarLibro){
            if(e.getClickCount() == 2){
                this.eliminarLibro();
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
