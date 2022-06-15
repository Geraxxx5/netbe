package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import vista.FrmLibros;
import vista.FrmMostrarAutor;
import vista.FrmMostrarLibros;


public class ControladorMostrar implements ActionListener, WindowListener{
    FrmMostrarAutor mMa = new FrmMostrarAutor();
    FrmAutores mA = new FrmAutores();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    //libro
    FrmLibros mL = new FrmLibros();
    FrmMostrarLibros mMl = new FrmMostrarLibros();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    public ControladorMostrar(FrmMostrarAutor mMa, FrmAutores mA, AutorVO avo, AutorDAO adao, FrmLibros mL, FrmMostrarLibros mMl, LibroVO lvo, LibroDAO ldao){
        this.mMa = mMa;
        this.mA = mA;
        this.avo = avo;
        this.adao = adao;
        //libro
        this.mL = mL;
        this.mMl = mMl;
        this.lvo = lvo;
        this.ldao = ldao;
        
        this.mMa.btnRegresar.addActionListener(this);
        this.mMa.addWindowListener(this);
        
        this.mMl.btnRegresar.addActionListener(this);
        this.mMl.addWindowListener(this);
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
          
        this.mMa.tblMostrarAutor.setModel(m);
        TableColumn cCero = this.mMa.tblMostrarAutor.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.mMa.tblMostrarAutor.getColumnModel().getColumn(1);
        cCero.setMaxWidth(180);
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
          
        this.mMl.tblMostrarLibros.setModel(m);
        TableColumn cCero = this.mMl.tblMostrarLibros.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.mMl.tblMostrarLibros.getColumnModel().getColumn(1);
        cCero.setMaxWidth(75);
        //aaaa
        TableColumn cDos = this.mMl.tblMostrarLibros.getColumnModel().getColumn(2);
        cCero.setMaxWidth(250);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mMa.btnRegresar){
            this.mMa.dispose();
            this.mA.setVisible(true);
        }
        if(e.getSource() == this.mMl.btnRegresar){
            this.mMl.dispose();
            this.mL.setVisible(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if(e.getSource() == this.mMa){
            this.mostrarAutor();
        }
        if(e.getSource() == this.mMl){
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
        if(e.getSource() == this.mMa){
            this.mostrarAutor();
        }
        if(e.getSource() == this.mMl){
            this.mostrarLibro();
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
