package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizacionLibro;
import vista.FrmEliminarLibro;
import vista.FrmInsertarLibro;
import vista.FrmLibros;
import vista.FrmMostrarLibros;

public class ControladorMenuLibros implements ActionListener {
    
    FrmLibros mL = new FrmLibros();
    FrmInsertarLibro mIl = new FrmInsertarLibro();
    FrmEliminarLibro mEl = new FrmEliminarLibro();
    FrmActualizacionLibro mAl = new FrmActualizacionLibro();
    FrmMostrarLibros mMl = new FrmMostrarLibros();
    
    public ControladorMenuLibros(FrmLibros mL, FrmInsertarLibro mIl, FrmEliminarLibro mEl, FrmActualizacionLibro mAl,FrmMostrarLibros mMl){
        this.mL = mL;
        this.mIl = mIl;
        this.mEl = mEl;
        this.mAl = mAl;
        this.mMl = mMl;
        
        this.mL.btnInsertarLibro.addActionListener(this);
        this.mL.btnEliminarLibro.addActionListener(this);
        this.mL.btnActualizarLibro.addActionListener(this);
        this.mL.btnMostrarLibro.addActionListener(this);
        this.mL.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mL.btnInsertarLibro){
            this.mIl.setVisible(true);
            this.mIl.setLocationRelativeTo(mL);
            this.mIl.setResizable(false);
            this.mL.setVisible(false);
        }
        if(e.getSource() == this.mL.btnEliminarLibro){
            this.mEl.setVisible(true);
            this.mEl.setLocationRelativeTo(mL);
            this.mEl.setResizable(false);
            this.mL.setVisible(false);
        }
        if(e.getSource() == this.mL.btnActualizarLibro){
            this.mAl.setVisible(true);
            this.mAl.setLocationRelativeTo(mL);
            this.mAl.setResizable(false);
            this.mL.setVisible(false);
        }
        if(e.getSource() == this.mL.btnMostrarLibro){
            this.mMl.setVisible(true);
            this.mMl.setLocationRelativeTo(mL);
            this.mMl.setResizable(false);
            this.mL.setVisible(false);
        }
        if(e.getSource() == this.mL.jButton1){
            this.mL.dispose();
        }
    }
}
