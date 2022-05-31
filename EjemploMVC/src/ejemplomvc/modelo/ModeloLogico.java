
package ejemplomvc.modelo;

public class ModeloLogico {
   
    public ModeloLogico(){
    } 

    private String res;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String palabra(){
        String a = "No selecciono nada";
        if(res == "Agua"){
            a = "Water";
        }
        if(res == "Pollo"){
            a = "Chicken";
        }
        if(res == "Sandia"){
            a = "Watermelon";
        }
        if(res == "Cuaderno"){
            a = "Notebook";
        }
        if(res == "Vida"){
            a = "Life";
        }
        if(res == "Pan"){
            a = "Bread";
        }
        return a;
    }

}
