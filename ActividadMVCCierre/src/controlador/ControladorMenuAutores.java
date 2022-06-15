package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizarAutores;
import vista.FrmAutores;
import vista.FrmEliminarAutor;
import vista.FrmInsertarAutores;
import vista.FrmMenuPrincipal;
import vista.FrmMostrarAutor;

public class ControladorMenuAutores implements ActionListener{

    FrmAutores mA = new FrmAutores();
    FrmInsertarAutores mIa = new FrmInsertarAutores();
    FrmEliminarAutor mEa = new FrmEliminarAutor();
    FrmActualizarAutores mAc = new FrmActualizarAutores();
    FrmMostrarAutor mMa = new FrmMostrarAutor();
    
    public ControladorMenuAutores(FrmAutores mA, FrmInsertarAutores mIa, FrmEliminarAutor mEa, FrmActualizarAutores mAc, FrmMostrarAutor mMa){
        this.mA = mA;
        this.mIa = mIa;
        this.mEa = mEa;
        this.mAc = mAc;
        this.mMa = mMa;
        
        this.mA.btnInsertar.addActionListener(this);
        this.mA.btnElimina.addActionListener(this);
        this.mA.btnActualizar.addActionListener(this);
        this.mA.btnMostrar.addActionListener(this);
        this.mA.btnRegresa.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.mA.btnInsertar){
            this.mIa.setVisible(true);
            this.mIa.setLocationRelativeTo(mA);
            this.mIa.setResizable(false);
            this.mA.setVisible(false);
        }
        if(e.getSource() == this.mA.btnElimina){
            this.mEa.setVisible(true);
            this.mEa.setLocationRelativeTo(mA);
            this.mEa.setResizable(false);
            this.mA.setVisible(false);
        }
        if(e.getSource() == this.mA.btnActualizar){
            this.mAc.setVisible(true);
            this.mAc.setLocationRelativeTo(mA);
            this.mAc.setResizable(false);
            this.mA.setVisible(false);
        }
        if(e.getSource() == this.mA.btnMostrar){
            this.mMa.setVisible(true);
            this.mMa.setLocationRelativeTo(mA);
            this.mMa.setResizable(false);
            this.mA.setVisible(false);
        }
        if(e.getSource() == this.mA.btnRegresa){
            this.mA.dispose();
        }
    }
    
    
}
