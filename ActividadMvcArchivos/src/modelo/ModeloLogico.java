
package modelo;

import java.io.*;

public class ModeloLogico {
    
    public ModeloLogico(){
        
    }
    
    private String texto;
    private File ruta;
    private FileWriter fw;
    private FileReader fr;
    private BufferedReader br;
    private String linea;
    private String inTexto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }
    
    public void guardarAr() throws IOException{
        //if( ruta != null){
            System.out.println(texto);
            if(!this.ruta.getAbsolutePath().endsWith(".txt")){
                fw = new FileWriter(this.ruta+".txt");
            }else{
                fw = new FileWriter(this.ruta);
            }
            fw.write(texto);
            fw.close();
    }
   
    
    public String abrirAr() throws FileNotFoundException, IOException{
        fr = new FileReader(ruta);
        br = new BufferedReader(fr);
        while((linea = br.readLine()) != null){
            inTexto+= linea+"\n";
        }
        br.close();
        return inTexto;
    }
    
}
