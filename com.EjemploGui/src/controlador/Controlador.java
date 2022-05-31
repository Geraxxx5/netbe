
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.FrmOperaciones;

public class Controlador implements ActionListener{
    FrmOperaciones vista = new FrmOperaciones();
    ModeloLogico modelo = new ModeloLogico();


    public Controlador(FrmOperaciones vista, ModeloLogico modelo){
        this.vista = vista;
        this.modelo = modelo;

        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.vista.jmul.addActionListener(this);
        this.vista.jdivi.addActionListener(this);
    }

    private void sum(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtn1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtn2.getText()));
        //vista.jopResultado.showMessageDialog(this.vista, modelo.suma());
        String a = String.valueOf(modelo.suma());
        vista.JlblRes.setText("Suma: "+a);
        
    }
    private void rest(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtn1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtn2.getText()));
        //vista.jopResultado.showMessageDialog(this.vista, modelo.resta());
        String a = String.valueOf(modelo.resta());
        vista.JlblRes.setText("Resta: "+a);
//ctrl + espacio
    }  

    private void multi(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtn1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtn2.getText()));
        String a = String.valueOf(modelo.multiplicacion());
        vista.JlblRes.setText("Multiplicacion: "+a);
    }

    private void divi(){
        this.modelo.setN1(Double.parseDouble(this.vista.txtn1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtn2.getText()));
        String a;
        a = String.valueOf(modelo.division());
        vista.JlblRes.setText("Divison: "+a);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == vista.jButton1){
            this.sum();
        }
        if(e.getSource() == vista.jButton2){
            this.rest();
        }
        if(e.getSource() == vista.jmul){
            this.multi();
        }
        if(e.getSource() == vista.jdivi){
            this.divi();
        }
    }

}
