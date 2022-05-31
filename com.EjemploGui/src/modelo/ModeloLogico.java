package modelo;

public class ModeloLogico {

    private double n1;
    private double n2;

    public ModeloLogico(){
    }

    public double getN1() {
        return n1;
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

    public int suma(){
        int s;
        s = (int)(this.n1 +this.n2);
        return s;
    }

    public int resta(){
        int r;
        r = (int)(this.n1-this.n2);
        return r;
    }

    public int multiplicacion(){
        int m;
        m = (int)(this.n1*this.n2);
        return m;
    }

    public double division(){
        double d;
        d = (double)(this.n1/this.n2);
        return d;
    }
}
