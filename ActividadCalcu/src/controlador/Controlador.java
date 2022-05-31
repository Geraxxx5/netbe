package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.ModeloLogico;
import vista.FrmCalcu;
public class Controlador implements ActionListener{
    
 
    FrmCalcu vista = new FrmCalcu();
    ModeloLogico modelo = new ModeloLogico();
    private String texto;
    private boolean bandera = true;
    
    
    public Controlador(FrmCalcu vista, ModeloLogico modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.jNumero1.addActionListener(this);
        this.vista.jNumero2.addActionListener(this);
        this.vista.jNumero3.addActionListener(this);
        this.vista.jNumero4.addActionListener(this);
        this.vista.jNumero5.addActionListener(this);
        this.vista.jNumero6.addActionListener(this);
        this.vista.jNumero7.addActionListener(this);
        this.vista.jNumero8.addActionListener(this);
        this.vista.jNumero9.addActionListener(this);
        this.vista.jNumero0.addActionListener(this);
        
        this.vista.jSumas.addActionListener(this);
        this.vista.jRestas.addActionListener(this);
        this.vista.jDividir.addActionListener(this);
        this.vista.jmultiplicar.addActionListener(this);
        this.vista.jPotencia.addActionListener(this);
        this.vista.jAbsoluto.addActionListener(this);
        this.vista.jRedondear.addActionListener(this);
        this.vista.jCambiosigno.addActionListener(this);
        this.vista.jSin.addActionListener(this);
        this.vista.jCos.addActionListener(this);
        this.vista.jTan.addActionListener(this);
        
        this.vista.jBotonC.addActionListener(this);
        this.vista.jBotonCE.addActionListener(this);
        this.vista.jBotonIgual.addActionListener(this);
        this.vista.jFileCho.addActionListener(this);
        
        this.dia();
    }
    
    private void agregarNum(int n){
        texto = this.vista.jNumeroGrande.getText();
        System.out.println(texto);
        if(texto != null){
            if(Double.parseDouble(texto) != 0){
                this.vista.jNumeroGrande.setText(texto+String.valueOf(n));
            }else{
                if(bandera){
                    this.vista.jNumeroGrande.setText(String.valueOf(n));
                }else{
                    this.bandera = true;
                }
            }
        }else{
            this.vista.jNumeroGrande.setText(texto+String.valueOf(n));
        }
    }
    
    public void dia(){
        this.vista.jTextoDia.setText(this.modelo.getFecha());
    }
    
    private void suma(){
        texto = this.vista.jNumeroGrande.getText();
        if((this.modelo.getN1() == 0) && (texto != "")){
            try{
                this.modelo.setN1(Double.parseDouble(texto));
                this.modelo.setOperador("+");
                this.vista.jTextoEcuacion.setText(texto+" + ");
                this.modelo.setDecorativo(this.vista.jTextoEcuacion.getText());
                this.borrarGrande();
            }
            catch(NumberFormatException ex){
                System.err.println("Error: "+ex);
            }
        }else{
            this.vista.jTextoEcuacion.setText(String.valueOf(this.modelo.getN1())+" + ");
        }
    }
    
    
    private void resta(){
        texto = this.vista.jNumeroGrande.getText();
        if((this.modelo.getN1() == 0) && (texto != "")){
            try{
                this.modelo.setN1(Double.parseDouble(texto));
                this.vista.jTextoEcuacion.setText(texto+" - ");
                this.modelo.setOperador("-");
                this.modelo.setDecorativo(this.vista.jTextoEcuacion.getText());
                this.borrarGrande();
            }
            catch(NumberFormatException ex){
                System.err.println("Error: "+ex);
            }
        }else{
            this.vista.jTextoEcuacion.setText(String.valueOf(this.modelo.getN1())+" - ");
            this.modelo.setOperador("-");
        }
    }
    
    @SuppressWarnings("empty-statement")
    private void resultado() throws IOException{
        if(this.modelo.getN1() != 0){
            texto = this.vista.jNumeroGrande.getText();
            if(texto == ""){
                this.modelo.setN2(0);
            }else{
                try{
                    this.modelo.setN2(Double.parseDouble(this.vista.jNumeroGrande.getText()));
                    this.vista.jNumeroGrande.setText(this.modelo.resultado());
                    this.vista.jTextoEcuacion.setText(this.modelo.getDecorativo()+String.valueOf(this.modelo.getN2()));
                    String var;
                    String[] options = {"Guardar","Cancelar"};
                    int x = this.vista.jNotificaciones.showOptionDialog(vista,"Quieres guardar el resultado","Notificacion",this.vista.jNotificaciones.DEFAULT_OPTION,this.vista.jNotificaciones.PLAIN_MESSAGE,null,options,options[0]);
                    if(x == 0){
                        String[] options2 = {"Crear","Abrir"};
                        int y = this.vista.jNotificaciones.showOptionDialog(vista,"¿Quiere Crear o abrir un archivo?","Notificacion",this.vista.jNotificaciones.DEFAULT_OPTION,this.vista.jNotificaciones.PLAIN_MESSAGE,null,options2,options2[0]);
                        if(y==1){
                            this.vista.jFileCho.showOpenDialog(vista);
                            this.modelo.setRuta(this.vista.jFileCho.getSelectedFile());
                            if(modelo.getRuta() != null){
                                modelo.escribir();
                                this.vista.jNotificaciones.showMessageDialog(vista, "El archivo se guardo exitosamente");
                            }
                        }else{
                            this.vista.jFileCho.showSaveDialog(vista);
                            this.modelo.setRuta((this.vista.jFileCho.getSelectedFile()));
                            if((modelo.getRuta() != null)){
                                this.modelo.escribir();
                                this.vista.jNotificaciones.showMessageDialog(vista, "El archivo se guardo exitosamente");
                            }
                        }
                    }
                }
                catch(NumberFormatException ex){
                    
                }
            }
        }else{
            this.vista.jNumeroGrande.setText("0");
        }
    }
    
    private void dividir(){
        texto = this.vista.jNumeroGrande.getText();
        if((this.modelo.getN1() == 0) && (texto != "")){
            try{
                this.modelo.setN1(Double.parseDouble(texto));
                this.vista.jTextoEcuacion.setText(texto+" / ");
                this.modelo.setOperador("/");
                this.modelo.setDecorativo(this.vista.jTextoEcuacion.getText());
                this.borrarGrande();
            }
            catch(NumberFormatException ex){
                System.err.println("Error: "+ex);
            }
        }else{
            this.vista.jTextoEcuacion.setText(String.valueOf(this.modelo.getN1())+" / ");
            this.modelo.setOperador("/");
        }
    }
    
    private void multiplicar(){
        texto = this.vista.jNumeroGrande.getText();
        if((this.modelo.getN1() == 0) && (texto != "")){
            try{
                this.modelo.setN1(Double.parseDouble(texto));
                this.vista.jTextoEcuacion.setText(texto+" x ");
                this.modelo.setOperador("x");
                this.modelo.setDecorativo(this.vista.jTextoEcuacion.getText());
                this.borrarGrande();
            }
            catch(NumberFormatException ex){
                System.err.println("Error: "+ex);
            }
        }else{
            this.vista.jTextoEcuacion.setText(String.valueOf(this.modelo.getN1())+" x ");
            this.modelo.setOperador("x");
        }
    }
    
    private void potencia(){
        texto = this.vista.jNumeroGrande.getText();
        if((this.modelo.getN1() == 0) && (texto != "")){
            try{
                this.modelo.setN1(Double.parseDouble(texto));
                this.vista.jTextoEcuacion.setText(texto+" ^ ");
                this.modelo.setOperador("^");
                this.modelo.setDecorativo(this.vista.jTextoEcuacion.getText());
                this.borrarGrande();
            }
            catch(NumberFormatException ex){
                System.err.println("Error: "+ex);
            }
        }else{
            this.vista.jTextoEcuacion.setText(String.valueOf(this.modelo.getN1())+" ^ ");
            this.modelo.setOperador("^");
        }
    }
    
    private void modulo(){
        if((this.modelo.getN1() == 0) && (texto != "")){
            try{
                this.modelo.setN1(Double.parseDouble(texto));
                this.vista.jTextoEcuacion.setText(texto+" % ");
                this.modelo.setOperador("%");
                this.modelo.setDecorativo(this.vista.jTextoEcuacion.getText());
                this.borrarGrande();
            }
            catch(NumberFormatException ex){
                System.err.println("Error: "+ex);
            }
        }else{
            this.vista.jTextoEcuacion.setText(String.valueOf(this.modelo.getN1())+" % ");
            this.modelo.setOperador("%");
        }
    }
    
    private void absoluto(){
        texto = this.vista.jNumeroGrande.getText();
        this.vista.jNumeroGrande.setText(String.valueOf(this.modelo.absoluto(Double.parseDouble(texto))));
    }
    
    private void redondear(){
        texto = this.vista.jNumeroGrande.getText();
        this.vista.jNumeroGrande.setText(String.valueOf(this.modelo.redondear(Double.parseDouble(texto))));
    }
    
    private void sin(){
        texto = this.vista.jNumeroGrande.getText();
        this.vista.jNumeroGrande.setText(String.valueOf(this.modelo.sin(Double.parseDouble(texto))));
        this.vista.jTextoEcuacion.setText(String.valueOf("sin("+texto+")"));
    }
    
    private void tan(){
        texto = this.vista.jNumeroGrande.getText();
        this.vista.jNumeroGrande.setText(String.valueOf(this.modelo.tan(Double.parseDouble(texto))));
        this.vista.jTextoEcuacion.setText(String.valueOf("tan("+texto+")"));
    }
    
    private void cos(){
        texto = this.vista.jNumeroGrande.getText();
        this.vista.jNumeroGrande.setText(String.valueOf(this.modelo.cos(Double.parseDouble(texto))));
        this.vista.jTextoEcuacion.setText(String.valueOf("cos("+texto+")"));
    }
    
    private void borrarTodo(){
        this.vista.jNumeroGrande.setText("0");
        this.vista.jTextoEcuacion.setText("");
        this.modelo.setN1(0);
        this.modelo.setN2(0);
    }
    
    private void borrarGrande(){
        this.vista.jNumeroGrande.setText("0");
        
    }
    
    private void cambio(){
        texto = this.vista.jNumeroGrande.getText();
        this.vista.jNumeroGrande.setText(String.valueOf(this.modelo.cambio(Double.parseDouble(texto))));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.jNumero1){;
            this.agregarNum(1);
        }
        if(e.getSource() == this.vista.jNumero2){
            this.agregarNum(2);
        }
        if(e.getSource() == this.vista.jNumero3){
            this.agregarNum(3);
        }
        if(e.getSource() == this.vista.jNumero4){
            this.agregarNum(4);
        }
        if(e.getSource() == this.vista.jNumero5){
            this.agregarNum(5);
        }
        if(e.getSource() == this.vista.jNumero6){
            this.agregarNum(6);
        }
        if(e.getSource() == this.vista.jNumero7){
            this.agregarNum(7);
        }
        if(e.getSource() == this.vista.jNumero8){
            this.agregarNum(8);
        }
        if(e.getSource() == this.vista.jNumero9){
            this.agregarNum(9);
        }
        if(e.getSource() == this.vista.jNumero0){
            this.bandera = false;
            this.agregarNum(0);
        }
        if(e.getSource() == this.vista.jSumas){
            this.suma();
        }
        if(e.getSource() == this.vista.jRestas){
            this.resta();
        }
        if(e.getSource() == this.vista.jBotonCE){
            this.borrarGrande();
        }
        if(e.getSource() == this.vista.jBotonIgual){
            try{
                this.resultado();
            }
            catch(IOException ex){
                System.err.println("Error: "+ex);
            }
        }
        if(e.getSource() == this.vista.jBotonC){
            this.borrarTodo();
        }
        if(e.getSource() == this.vista.jDividir){
            this.dividir();
        }
        if(e.getSource() == this.vista.jmultiplicar){
            this.multiplicar();
        }
        if(e.getSource() == this.vista.jPotencia){
            this.potencia();
        }
        if(e.getSource() == this.vista.jModulo){
            this.modulo();
        }
        if(e.getSource() == this.vista.jAbsoluto){
            this.absoluto();
        }
        if(e.getSource() == this.vista.jRedondear){
            this.redondear();
        }
        if(e.getSource() == this.vista.jCambiosigno){
            this.cambio();
        }
        if(e.getSource() == this.vista.jSin){
            this.sin();
        }
        if(e.getSource() == this.vista.jCos){
            this.cos();
        }
        if(e.getSource() == this.vista.jTan){
            this.tan();
        }
    }


}
