
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import modelo.ModeloLogico;
import vista.frmArchivos;


public class Controlador implements ActionListener{
    
    ModeloLogico modelo = new ModeloLogico();
    frmArchivos vista = new frmArchivos();

    public Controlador(frmArchivos vista,ModeloLogico modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.AbrirArch.addActionListener(this);
        this.vista.FiloChooser.addActionListener(this);
        this.vista.GuardarArch.addActionListener(this);

    }
    
    public void abrir() throws IOException{
        this.vista.FiloChooser.showOpenDialog(vista);
        this.vista.entryTexto.setText(" ");
        this.modelo.setRuta(this.vista.FiloChooser.getSelectedFile());
        if(modelo.getRuta() != null){
            vista.entryTexto.setText(modelo.abrirAr());
        }
    }
    
    public void guardar() throws IOException{
        this.modelo.setTexto(this.vista.entryTexto.getText());
        if(modelo.getRuta() != null){
            this.modelo.guardarAr();
            this.vista.Notificaciones.showMessageDialog(vista, "El archivo se guardo exitosamente");
        }else{
            this.vista.FiloChooser.showSaveDialog(vista);
            this.modelo.setRuta((this.vista.FiloChooser.getSelectedFile()));
            if((modelo.getRuta() != null)){
                this.modelo.guardarAr();
                this.vista.Notificaciones.showMessageDialog(vista, "El archivo se guardo exitosamente");
            }
        }
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.vista.AbrirArch){
            try{
                this.abrir();
            }
            catch(IOException ex){
                System.err.println("Error: "+ex);
            }
        }
        if(e.getSource() == this.vista.GuardarArch){
            System.out.println("Holaaaaaaaaaaaaaa");
            try{
                this.guardar();
            }
            catch(IOException ex){
                System.err.println("Error: "+ex);
            }
            
        }
    }
}
