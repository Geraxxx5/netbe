package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Extras;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmAutores;
import vista.FrmInsertarAutores;
import vista.FrmInsertarLibro;
import vista.FrmLibros;

public class ControladorInsertar implements ActionListener,WindowListener{
    
    FrmInsertarAutores mIn = new FrmInsertarAutores();
    FrmAutores mA = new FrmAutores();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    //libros
    FrmLibros mL = new FrmLibros();
    FrmInsertarLibro mIl = new FrmInsertarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    public ControladorInsertar(FrmAutores mA ,FrmInsertarAutores mIn, AutorVO avo, AutorDAO adao, FrmLibros mL, FrmInsertarLibro mIl, LibroVO lvo, LibroDAO ldao){
        //Autores
        this.mA = mA;
        this.mIn = mIn;
        this.avo = avo;
        this.adao = adao;
        //Libro
        this.mL = mL;
        this.mIl = mIl;
        this.lvo = lvo;
        this.ldao = ldao;
        
        //Autor
        this.mIn.btnNuevoCancelar.addActionListener(this);
        this.mIn.btnNuevoReg.addActionListener(this);
        //Lirbo
        this.mIl.btnNuevoRegistro.addActionListener(this);
        this.mIl.btnNuevoCancelar.addActionListener(this);
        this.mIl.addWindowListener(this);
    }
    
    
    private void insertarAutor(){
        String nombreAutor;
        String generoAutor;
        try {
            if((this.mIn.txtSeudonimoAutor.getText() != "")&&(this.mIn.txtEdadAutor.getText() != "")){
                if(this.mIn.txtNombreAutor.getText() == ""){
                    nombreAutor = null; 
                }else{
                    nombreAutor = this.mIn.txtNombreAutor.getText();
                }
                if(this.mIn.txtGeneroAutor.getText() == ""){
                    generoAutor = null;
                }else{
                    generoAutor = this.mIn.txtGeneroAutor.getText();
                }
                this.avo.setNombreAutor(nombreAutor);
                this.avo.setSeudonimoAutor(this.mIn.txtSeudonimoAutor.getText());
                boolean bandera = Extras.validarExistencia(this.mIn.txtSeudonimoAutor.getText());
                if (!bandera){
                    this.avo.setEdadAutor(Integer.parseInt(this.mIn.txtEdadAutor.getText()));
                    this.avo.setGeneroAutor(generoAutor);
                    if(this.adao.insertarAutor(avo) == true){
                        this.mIn.jopMensaje.showMessageDialog(mIn, "Datos Insertados Correctamente");
                        this.mIn.txtEdadAutor.setText("");
                        this.mIn.txtGeneroAutor.setText("");
                        this.mIn.txtNombreAutor.setText("");
                        this.mIn.txtSeudonimoAutor.setText("");
                    }else{
                        this.mIn.jopMensaje.showMessageDialog(mIn, "Error, datos no encontrados correctamente");
                        this.mIn.txtEdadAutor.setText("");
                        this.mIn.txtGeneroAutor.setText("");
                        this.mIn.txtNombreAutor.setText("");
                        this.mIn.txtSeudonimoAutor.setText("");
                    }
                }else{
                    this.mIn.jopMensaje.showMessageDialog(mIn, "Ya existe una persona con ese seudonimo");
                }    
            }else{
                this.mIn.jopMensaje.showMessageDialog(mIn, "Ingrese todos los campos");
            }
        } catch (Exception e) {
            this.mIn.jopMensaje.showMessageDialog(mIn, "Error: "+e);
        }
    }
    
    private void llenarCombobox(){
        this.mIl.comboAutor.removeAllItems();
        for(AutorVO avo: Extras.datosCombo()){
            this.mIl.comboAutor.addItem(avo.getSeudonimoAutor());
        }
    }
    
    private void insertarLibro(){
        String seudonimo = String.valueOf(this.mIl.comboAutor.getSelectedItem());
        if((this.mIl.txtNombreLibro.getText() != "")&&(this.mIl.txtFechaPublicacion.getText() != "")&&(this.mIl.txtGeneroPrincipal.getText() != "")&&(this.mIl.txtNumeroPagina.getText() != "")){
            try {
                lvo.setIdAutorFk(Extras.retornarId(seudonimo));
                lvo.setNombreLibro(this.mIl.txtNombreLibro.getText());
                lvo.setFechaPublicacionLibro(Date.valueOf(this.mIl.txtFechaPublicacion.getText()));
                lvo.setNumeroPaginasLibro(Integer.parseInt(this.mIl.txtNumeroPagina.getText()));
                lvo.setGeneroPrincipalLibro(this.mIl.txtGeneroPrincipal.getText());
                if(this.ldao.insertarLibro(lvo) == true){
                    this.mIl.jopMensaje.showMessageDialog(mIn, "Datos Insertados Correctamente");
                    this.mIl.txtNombreLibro.setText("");
                    this.mIl.txtFechaPublicacion.setText("");
                    this.mIl.txtNumeroPagina.setText("");
                    this.mIl.txtGeneroPrincipal.setText("");
                }else{
                    this.mIl.jopMensaje.showMessageDialog(mIn, "Error, no se logro ingresar los datos");
                    this.mIl.txtNombreLibro.setText("");
                    this.mIl.txtFechaPublicacion.setText("");
                    this.mIl.txtNumeroPagina.setText("");
                    this.mIl.txtGeneroPrincipal.setText("");
                }
            } catch (Exception e) {
                this.mIl.jopMensaje.showMessageDialog(mIn, "Error, datos ingresados incorrectamente: "+e);
            }
        }else{
            this.mIl.jopMensaje.showMessageDialog(mIn, "Error, tiene que llenar todos los campos");
        }      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mIn.btnNuevoCancelar){
            this.mIn.dispose();
            this.mA.setVisible(true);
        }
        if(e.getSource() == this.mIn.btnNuevoReg){
            this.insertarAutor();
        }
        if(e.getSource() == this.mIl.btnNuevoCancelar){
            this.mIl.dispose();
            this.mL.setVisible(true);
        }
        if(e.getSource() == this.mIl.btnNuevoRegistro){
            this.insertarLibro();
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
        this.llenarCombobox();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
