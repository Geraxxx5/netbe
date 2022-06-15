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
import vista.FrmActualizacionLibro;
import vista.FrmActualizarAutores;
import vista.FrmAutores;
import vista.FrmLibros;
import java.sql.Date;

public class ControladorActualizar implements ActionListener, WindowListener, MouseListener {

    FrmActualizarAutores mAc = new FrmActualizarAutores();
    FrmAutores vMa = new FrmAutores();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    //libro
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    FrmLibros mL = new FrmLibros();
    FrmActualizacionLibro mAl = new FrmActualizacionLibro();
    
    public ControladorActualizar(FrmActualizarAutores mAc, FrmAutores vMa, AutorVO avo, AutorDAO adao, FrmLibros mL, FrmActualizacionLibro mAl, LibroVO lvo, LibroDAO ldao){
        this.mAc = mAc;
        this.vMa = vMa;
        this.avo = avo;
        this.adao = adao;
        //Libro
        this.mL = mL;
        this.mAl = mAl;
        this.lvo = lvo;
        this.ldao = ldao;
        
        this.mAc.btnActualizar.addActionListener(this);
        this.mAc.btnRegresar.addActionListener(this);
        this.mAc.tblModificarAutor.addMouseListener(this);
        this.mAc.addWindowListener(this);
        //Libro
        this.mAl.btnActualizar.addActionListener(this);
        this.mAl.btnRegresar.addActionListener(this);
        this.mAl.addWindowListener(this);
        this.mAl.tblModificarLibro.addMouseListener(this);
    }
    
    private void mostrarDatosAutor(){
        int row = this.mAc.tblModificarAutor.getSelectedRow();
        this.mAc.txtIdAut.setText(String.valueOf(this.mAc.tblModificarAutor.getValueAt(row, 0)));
        this.mAc.txtNombreAutor.setText(String.valueOf(this.mAc.tblModificarAutor.getValueAt(row, 1)));
        this.mAc.txtSeudonimoAutor.setText(String.valueOf(this.mAc.tblModificarAutor.getValueAt(row, 2)));
        this.mAc.txtEdadAutor.setText(String.valueOf(this.mAc.tblModificarAutor.getValueAt(row, 3)));
        this.mAc.txtGeneroAutor.setText(String.valueOf(this.mAc.tblModificarAutor.getValueAt(row, 4)));
    }
    
    private void mostrarDatosLibro(){
        int row = this.mAl.tblModificarLibro.getSelectedRow();
        this.mAl.txtIdLibro.setText(String.valueOf(this.mAl.tblModificarLibro.getValueAt(row, 0)));
        this.llenarCombobox(String.valueOf(this.mAl.tblModificarLibro.getValueAt(row, 1)));
        this.mAl.txtNombreLibro.setText(String.valueOf(this.mAl.tblModificarLibro.getValueAt(row, 2)));
        this.mAl.txtFechaPublicacion.setText(String.valueOf(this.mAl.tblModificarLibro.getValueAt(row, 3)));
        this.mAl.txtNumeroPaginas.setText(String.valueOf(this.mAl.tblModificarLibro.getValueAt(row, 4)));
        this.mAl.txtGeneroPrinci.setText(String.valueOf(this.mAl.tblModificarLibro.getValueAt(row, 5)));   
    }
    
    private void actualizarLibro(){
        String seudonimo = String.valueOf(this.mAl.comboAutores.getSelectedItem());
        try {
            if((this.mAl.txtIdLibro.getText() != "")){
                if((this.mAl.txtNombreLibro.getText() != "")&&(this.mAl.txtFechaPublicacion.getText() != "")&&(this.mAl.txtNumeroPaginas.getText() != "")&&(this.mAl.txtGeneroPrinci.getText() != "")){
                    this.lvo.setIdLibro(Integer.parseInt(this.mAl.txtIdLibro.getText()));
                    this.lvo.setIdAutorFk(Extras.retornarId(seudonimo));
                    this.lvo.setNombreLibro(this.mAl.txtNombreLibro.getText());
                    this.lvo.setFechaPublicacionLibro(Date.valueOf(this.mAl.txtFechaPublicacion.getText()));
                    this.lvo.setNumeroPaginasLibro(Integer.parseInt(this.mAl.txtNumeroPaginas.getText()));
                    this.lvo.setGeneroPrincipalLibro(this.mAl.txtGeneroPrinci.getText());
                    if(this.ldao.actualizarLibro(lvo) == true){
                        this.mAl.jopMensaje.showMessageDialog(mAl, "Datos actualizados");
                        this.mAl.comboAutores.removeAllItems();
                        this.mAl.txtIdLibro.setText("");
                        this.mAl.txtNombreLibro.setText("");
                        this.mAl.txtFechaPublicacion.setText("");
                        this.mAl.txtNumeroPaginas.setText("");
                        this.mAl.txtGeneroPrinci.setText("");
                    }else{
                        this.mAl.jopMensaje.showMessageDialog(mAl, "Error al actualizar los datos");
                        this.mAl.comboAutores.removeAllItems();
                        this.mAl.txtIdLibro.setText("");
                        this.mAl.txtNombreLibro.setText("");
                        this.mAl.txtFechaPublicacion.setText("");
                        this.mAl.txtNumeroPaginas.setText("");
                        this.mAl.txtGeneroPrinci.setText("");
                    }
                }else{
                    this.mAl.jopMensaje.showMessageDialog(mAl, "Error, Todos los campos tienen que estar llenos");
                }
            }else{
                this.mAl.jopMensaje.showMessageDialog(mAl, "Error, primero seleccione un registro para modificar");
            }
        } catch (Exception e) {
            this.mAl.jopMensaje.showMessageDialog(mAl, "Error, primero seleccione un registro para modificar");
        }
    }
    
    private void ActualizarAutor(){
        try {
            this.avo.setIdAutor(Integer.parseInt(this.mAc.txtIdAut.getText()));
            this.avo.setNombreAutor(this.mAc.txtNombreAutor.getText());
            this.avo.setGeneroAutor(this.mAc.txtGeneroAutor.getText());
            if((this.mAc.txtSeudonimoAutor.getText() != "")&&(this.mAc.txtEdadAutor.getText() != "")){
                this.avo.setSeudonimoAutor(this.mAc.txtSeudonimoAutor.getText());
                this.avo.setEdadAutor(Integer.parseInt(this.mAc.txtEdadAutor.getText()));
                if(this.adao.actualizarAutor(avo) == true){
                    this.mAc.jopMensajes.showMessageDialog(mAc, "Se actualizaron correctamente los datos");
                    this.mAc.txtIdAut.setText("");
                    this.mAc.txtNombreAutor.setText("");
                    this.mAc.txtSeudonimoAutor.setText("");
                    this.mAc.txtEdadAutor.setText("");
                    this.mAc.txtGeneroAutor.setText("");
                    this.mostrarAutor();
                }else{
                    this.mAc.jopMensajes.showMessageDialog(mAc, "Error, no se pudo actualizar los datos");
                    this.mAc.txtIdAut.setText("");
                    this.mAc.txtNombreAutor.setText("");
                    this.mAc.txtSeudonimoAutor.setText("");
                    this.mAc.txtEdadAutor.setText("");
                    this.mAc.txtGeneroAutor.setText("");
                }
            }else{
                this.mAc.jopMensajes.showMessageDialog(mAc, "Error, No puede dejar en blanco los campos de seudonimo y edad");
            }
        } catch (Exception e) {
            this.mAc.jopMensajes.showMessageDialog(mAc, "Error, Ingresar Correctamente los datos");
        }   
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
          
        this.mAc.tblModificarAutor.setModel(m);
        TableColumn cCero = this.mAc.tblModificarAutor.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.mAc.tblModificarAutor.getColumnModel().getColumn(1);
        cCero.setMaxWidth(180);
    }
    
    private void llenarCombobox(String seudonimo){
        this.mAl.comboAutores.removeAllItems();
        this.mAl.comboAutores.addItem(seudonimo);
        int idAutor = Extras.retornarId(seudonimo);
        for(AutorVO avo: Extras.datosCombo()){
            if(avo.getIdAutor() != idAutor){
                this.mAl.comboAutores.addItem(avo.getSeudonimoAutor());
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
          
        this.mAl.tblModificarLibro.setModel(m);
        TableColumn cCero = this.mAl.tblModificarLibro.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        //cCero.setMinWidth(0);
        TableColumn cUno = this.mAl.tblModificarLibro.getColumnModel().getColumn(1);
        cCero.setMaxWidth(75);
        //aaaa
        TableColumn cDos = this.mAl.tblModificarLibro.getColumnModel().getColumn(2);
        cCero.setMaxWidth(250);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mAc.btnRegresar){
            this.mAc.dispose();
            this.vMa.setVisible(true);
        }
        if(e.getSource() == this.mAc.btnActualizar){
            this.ActualizarAutor();
        }
        if(e.getSource() == this.mAl.btnRegresar){
            this.mAl.dispose();
            this.mL.setVisible(true);
        }
        if(e.getSource() == this.mAl.btnActualizar){
            this.actualizarLibro();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if(e.getSource() == this.mAc){
            this.mostrarAutor();
        }
        if(e.getSource() == this.mAl){
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
        if(e.getSource() == this.mAc){
            this.mostrarAutor();
        }
        if(e.getSource() == this.mAl){
            this.mostrarLibro();
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.mAc.tblModificarAutor){
            if(e.getClickCount() == 2){
                this.mostrarDatosAutor();
            }
        }
        if(e.getSource() == this.mAl.tblModificarLibro){
            if(e.getClickCount() == 2){
                this.mostrarDatosLibro();
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
