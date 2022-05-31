
package modelo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.lang.Math;
import java.io.*;

public class ModeloLogico {
    
    private double n1;
    private double n2;
    private String operador;
    private DateTimeFormatter fecha;
    private LocalDateTime tLocal;
    private String res;
    private String decorativo;
    private File ruta;
    private FileWriter fw;
    private FileReader fr;
    private BufferedReader br;
    private String linea;
    private String texto;
    private String inTexto;

    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }

    
    public String getDecorativo() {
        return decorativo;
    }

    public void setDecorativo(String decorativo) {
        this.decorativo = decorativo;
    }
    

    public double getN1() {
        return n1;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }
    
    public void escribir() throws IOException{
        texto = String.valueOf(n1+operador+n2+" = "+this.resultado());
        if(!this.ruta.getAbsolutePath().endsWith(".txt")){
            System.out.println("Hola sie entro 1");
            System.out.println(ruta);
            fw = new FileWriter(this.ruta+".txt");
            fw.close();
            fr = new FileReader(ruta+".txt");
            br = new BufferedReader(fr);
        }else{
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
        }
        while((linea = br.readLine()) != null){
            inTexto+= linea+"\n";
        }
        br.close();
        if(!this.ruta.getAbsolutePath().endsWith(".txt")){
            System.out.println("Hola sie entro 2");
            fw = new FileWriter(this.ruta+".txt");
        }else{
            fw = new FileWriter(this.ruta);
        }
        if(inTexto == null){
            fw.write(texto);
            fw.close();
        }else{
            inTexto += ("\n"+texto);
            fw.write(inTexto);
            fw.close();
        }
    }
    
    public String getFecha(){
        System.out.println(n1);
        fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        tLocal = LocalDateTime.now();
        return(fecha.format(tLocal));
    }
    
    public double absoluto(double n){
        n = Math.abs(n);
        return n;
    }
    
    public double redondear(double n){
        n = Math.round(n);
        return n;
    }
    
    public double cambio(double n){
        n = n*-1;
        return n;
    }
    
    public double sin(double n){
        n = Math.sin(n);
        return n;
    }
    
    public double cos(double n){
        n = Math.cos(n);
        return n;
    }
    
    public double tan(double n){
        n = Math.tan(n);
        return n;
    }

    public String resultado() {
       
        switch(operador){
            case "+":
                res = String.valueOf(n1+n2);
                break;
            case "-":
                res = String.valueOf(n1-n2);
                break;
            case "x":
                res = String.valueOf(n1*n2);
                break;
            case "/":
                if(n2 != 0){
                    res = String.valueOf(n1/n2);
                }else{
                    res = "Syntax Error";
                }
                break;
            case "^":
                res = String.valueOf(Math.pow(n1, n2));
                break;
            case "%":
                res = String.valueOf(n1%n2);
                break;
                
        }
        return res;
    }
    
    
    
    
}
