package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorLibroDAO;
import modelo.AutorLibroVO;
import modelo.AutorVO;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmMenuPrincipal;
import vista.FrmMostrarGeneral;

public class ControladorMostrarTodo implements ActionListener, WindowListener, ItemListener{

    FrmMenuPrincipal mP = new FrmMenuPrincipal();
    FrmMostrarGeneral mMg = new FrmMostrarGeneral();
    
    //daovo
    AutorLibroVO alvo = new AutorLibroVO();
    AutorLibroDAO aldao = new AutorLibroDAO();
    private int contador;
    ArrayList<String> list = new ArrayList<>();
    
    public ControladorMostrarTodo(FrmMenuPrincipal mP, FrmMostrarGeneral mMg,AutorLibroVO alvo,AutorLibroDAO aldao){
        this.mP = mP;
        this.mMg = mMg;
        this.alvo = alvo;
        this.aldao = aldao;
        
        this.contador = 0;
        
        
        this.mMg.btnGenerarTabla.addActionListener(this);
        this.mMg.rbEdadAutor.addItemListener(this);
        this.mMg.rbFechaPublicacion.addItemListener(this);
        this.mMg.rbGeneroAutor.addItemListener(this);
        this.mMg.rbGeneroPrincipal.addItemListener(this);
        this.mMg.rbIdAutor.addItemListener(this);
        this.mMg.rbIdAutorLibro.addItemListener(this);
        this.mMg.rbIdLibro.addItemListener(this);
        this.mMg.rbNombreAutor.addItemListener(this);
        this.mMg.rbNombreLibro.addItemListener(this);
        this.mMg.rbNumerodePagina.addItemListener(this);
        this.mMg.rbSeudonimoAutor.addItemListener(this);
    }
    
    private void hacerQuery(String valor, boolean accion){
        if(accion){
            this.list.add(valor);
        }else{
            this.list.remove(valor);
        }
    }
    
    private void crearTabla(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        m.setColumnCount(0);
        for(String data : list){
            if(data == "a.id_autor"){
                m.addColumn("id del Autor");
            }
            if(data == "a.nombre_autor"){
                m.addColumn("Nombre del Autor");
            }
            if(data == "a.seudonimo_autor"){
                m.addColumn("Seudonimo del Autor");
            }
            if(data == "a.edad_autor"){
                m.addColumn("Edad del Autor");
            }
            if(data == "a.genero_autor"){
                m.addColumn("Genero del Autor");
            }
            if(data == "l.id_libro"){
                m.addColumn("id del Libro");
            }
            if(data == "l.id_autor_fk"){
                m.addColumn("id del Autor");
            }
            if(data == "l.nombre_libro"){
                m.addColumn("Nombre del Libro");
            }
            if(data == "l.fecha_publicacion_libro"){
                m.addColumn("Fecha de Publicacion del Libro");
            }
            if(data == "l.numero_paginas_libro"){
                m.addColumn("Numero de paginas del libro");
            }
            if(data == "l.genero_principal_libro"){
                m.addColumn("Genero Principal del libro");
            }
        }
        this.mMg.tblMostrarAutoresLibro.setModel(m);
        
        for(AutorLibroVO alvo : aldao.consultaJoin(list)){
            Vector<Object> fila = new Vector<Object>();
            for(String data : list){
                if(data == "a.id_autor"){
                    fila.add(alvo.getIdAutor());
                }
                if(data == "a.nombre_autor"){
                    fila.add(alvo.getNombreAutor());
                }
                if(data == "a.seudonimo_autor"){
                    fila.add(alvo.getSeudonimoAutor());
                }
                if(data == "a.edad_autor"){
                    fila.add(alvo.getEdadAutor());
                }
                if(data == "a.genero_autor"){
                    fila.add(alvo.getGeneroAutor());
                }
                if(data == "l.id_libro"){
                    fila.add(alvo.getIdLibro());
                }
                if(data == "l.id_autor_fk"){
                    fila.add(alvo.getIdAutorFk());
                }
                if(data == "l.nombre_libro"){
                    fila.add(alvo.getNombreLibro());
                }
                if(data == "l.fecha_publicacion_libro"){
                    fila.add(alvo.getFechaPublicacionLibro());
                }
                if(data == "l.numero_paginas_libro"){
                    fila.add(alvo.getNumeroPaginasLibro());
                }
                if(data == "l.genero_principal_libro"){
                    fila.add(alvo.getGeneroPrincipalLibro());
                }
            }
            m.addRow(fila);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mMg.btnGenerarTabla){
            this.crearTabla();
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == this.mMg.rbEdadAutor){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("a.edad_autor", true);
            }else{
                this.contador--;
                this.hacerQuery("a.edad_autor", false);
            }
        }
        if(e.getSource() == this.mMg.rbFechaPublicacion){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("l.fecha_publicacion_libro", true);
            }else{
                this.contador--;
                this.hacerQuery("l.fecha_publicacion_libro", false);
            }
        }
        if(e.getSource() == this.mMg.rbGeneroAutor){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("a.genero_autor", true);
            }else{
                this.contador--;
                this.hacerQuery("a.genero_autor", false);
            }
        }
        if(e.getSource() == this.mMg.rbGeneroPrincipal){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("l.genero_principal_libro", true);
            }else{
                this.contador--;
                this.hacerQuery("l.genero_principal_libro", false);
            }
        }
        if(e.getSource() == this.mMg.rbIdAutor){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("a.id_autor", true);
            }else{
                this.contador--;
                this.hacerQuery("a.id_autor", false);
            }
        }
        if(e.getSource() == this.mMg.rbIdAutorLibro){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("l.id_autor_fk", true);
            }else{
                this.contador--;
                this.hacerQuery("l.id_autor_fk", false);
            }
        }
        if(e.getSource() == this.mMg.rbIdLibro){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("l.id_libro", true);
            }else{
                this.contador--;
                this.hacerQuery("l.id_libro", false);
            }
        }
        if(e.getSource() == this.mMg.rbNombreAutor){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("a.nombre_autor", true);
            }else{
                this.contador--;
                this.hacerQuery("a.nombre_autor", false);
            }
        }
        if(e.getSource() == this.mMg.rbNombreLibro){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("l.nombre_libro", true);
            }else{
                this.contador--;
                this.hacerQuery("l.nombre_libro", false);
            }
        }
        if(e.getSource() == this.mMg.rbNumerodePagina){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("l.numero_paginas_libro", true);
            }else{
                this.contador--;
                this.hacerQuery("l.numero_paginas_libro", false);
            }
        }
        if(e.getSource() == this.mMg.rbSeudonimoAutor){
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.contador++;
                this.hacerQuery("a.seudonimo_autor", true);
            }else{
                this.contador--;
                this.hacerQuery("a.seudonimo_autor", false);
            }
        }
    }
    
}
