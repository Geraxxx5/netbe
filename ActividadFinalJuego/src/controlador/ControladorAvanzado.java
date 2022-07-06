package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.UsuarioScoreDAO;
import modelo.UsuarioScoreVO;
import vista.FrmAvanzado;
import vista.FrmIndex;
import vista.FrmIntermedio;
import vista.FrmModificarUsuario;
import vista.FrmPrincipiante;

public class ControladorAvanzado implements ActionListener{

    FrmAvanzado vAvanzado = new FrmAvanzado();
    FrmPrincipiante vPrinci = new FrmPrincipiante();
    FrmIntermedio vInte = new FrmIntermedio();
    FrmIndex vInde = new FrmIndex();
    
    FrmModificarUsuario vMus = new FrmModificarUsuario();
    
    UsuarioScoreVO usvo = new UsuarioScoreVO();
    UsuarioScoreDAO usdao = new UsuarioScoreDAO();
    
    String usuario;
    
    ArrayList<String> palabras = new ArrayList<>();
    int largoArray;
    
    int numeroAdivinar;
    int pos1 = -1;
    int pos2 = -1;
    int pos3 = -1;
    
    String palabra1;
    String palabra2;
    String palabra3;
    
    String traPalabra1;
    String traPalabra2;
    String traPalabra3;
    
    int vidas = 3;
    
    int puntos = 0;
    int puntosJuego = 0;
    
    public ControladorAvanzado(FrmModificarUsuario vMus, FrmIndex vInde, FrmIntermedio vInte, FrmPrincipiante vPrinci, String usuario, FrmAvanzado vAvanzado, UsuarioScoreVO usvo, UsuarioScoreDAO usdao){
        this.usuario = usuario;
        this.vAvanzado = vAvanzado;
        this.usvo = usvo;
        this.usdao = usdao;
        this.vPrinci = vPrinci;
        this.vInte = vInte;
        this.vInde = vInde;
        this.vMus = vMus;
        
        this.header();
        this.numeroAlAzar();
        this.pala();
        this.palabrasAlAzar();
        
        this.vAvanzado.btnVerificarAdivinar.addActionListener(this);
        this.vAvanzado.btnVerificarTraducir.addActionListener(this);
        this.vAvanzado.btnFinalizarJuego.addActionListener(this);
        this.vAvanzado.btnModificarUsuario.addActionListener(this);
    }
    
    private void header(){
        this.vAvanzado.lblUsuario.setText(usuario);
        this.usvo.setUserUsuario(usuario);
        if(this.usdao.existenciaTablaScore(usvo)){
            this.puntos = Integer.parseInt(usdao.consultarDatos("punteo_score", usuario));
            this.vAvanzado.lblPunteo.setText("Punteo: "+puntos);
            this.usvo.setApellidoUsuario(usdao.consultarDatos("apellido_usuario", usuario));
            this.usvo.setEdadUsuario(Integer.parseInt(usdao.consultarDatos("edad_usuario", usuario)));
            this.usvo.setIdUsuario(Integer.parseInt(usdao.consultarDatos("id_usuario", usuario)));
            this.usvo.setNombreUsuario(usdao.consultarDatos("nombre_usuario", usuario));
            this.usvo.setPassUsuario(usdao.consultarDatos("pass_usuario", usuario));
            this.usvo.setIdScore(Integer.parseInt(usdao.consultarDatos("id_score", usuario)));
        }
    }
    
    private void cambiarPunteo(){
        this.vAvanzado.lblPunteo.setText("Punteo: "+puntos);
    }
    
    private void numeroAlAzar(){
        numeroAdivinar = (int) Math.floor(Math.random()*(0-15+1)+15);
        System.out.println(numeroAdivinar);
    }
    
    private void palabrasAlAzar(){
        pos1 = (int) Math.floor(Math.random()*(0-(largoArray-1)+1)+(largoArray-1));
        while(true){
            pos2 = (int) Math.floor(Math.random()*(0-(largoArray-1)+1)+(largoArray-1));
            if(pos2 != pos1){
                break;
            }
        }
        while(true){
            pos3 = (int) Math.floor(Math.random()*(0-(largoArray-1)+1)+(largoArray-1));
            if((pos3 != pos1)&&(pos3 != pos2)){
                break;
            }
        }
        palabra1 = this.palabras.get(pos1);
        palabra2 = this.palabras.get(pos2);
        palabra3 = this.palabras.get(pos3);
        
        this.vAvanzado.lblPalabra1.setText(palabra1);
        this.vAvanzado.lblPalabra2.setText(palabra2);
        this.vAvanzado.lblPalabra3.setText(palabra3);
    }
    
    private String traducir(String palabra){
        String traduccion = "";
        switch(palabra){
            case "Water":
                traduccion = "agua";
                break;
            case "Sun":
                traduccion = "sol";
                break;
            case "Letter":
                traduccion = "carta";
                break;
            case "Computer":
                traduccion = "computadora";
                break;
            case "Control":
                traduccion = "control";
                break;
            case "Blue":
                traduccion = "azul";
                break;
            case "Alarm":
                traduccion = "alarma";
                break;
            case "Purple":
                traduccion = "morado";
                break;
            case "Box":
                traduccion = "caja";
                break;
            case "Rose":
                traduccion = "rosa";
                break;
            case "Future":
                traduccion = "futuro";
                break;
            case "First":
                traduccion = "primero";
                break;
            case "Best":
                traduccion = "mejor";
                break;
            case "Closed":
                traduccion = "cerrado";
                break;
            case "Love":
                traduccion = "amor";
                break;
        }
        return traduccion;
    }
    
    private void pala(){
        palabras.add("Water");
        palabras.add("Sun");
        palabras.add("Letter");
        palabras.add("Computer");
        palabras.add("Control");
        palabras.add("Blue");
        palabras.add("Purple");
        palabras.add("Alarm");
        palabras.add("Box");
        palabras.add("Rose");
        palabras.add("Future");
        palabras.add("First");
        palabras.add("Best");
        palabras.add("Closed");
        palabras.add("Love");
        
        largoArray = palabras.size();
    }
    
    private void verificarAdivinar(){
        if(this.vidas != 0){
            if(this.vAvanzado.txtNumeroAzar.getText().equals(String.valueOf(numeroAdivinar))){
                this.vAvanzado.jopMensaje.showMessageDialog(vAvanzado, "Felicidades econtraste el numero\nGanaste 3 punto");
                puntos = puntos+3;
                this.usvo.setPunteoScore((puntos));
                this.usdao.cambiarPunteo(usvo);
                this.cambiarPunteo();
                this.vidas = 3;
                this.numeroAlAzar();
                this.vAvanzado.txtNumeroAzar.setText("");
            }else{
                this.vidas--;
                this.vAvanzado.jopMensaje.showMessageDialog(vAvanzado, "Ese no es el numero\nAun tienes "+vidas+" vidas");
                this.vAvanzado.txtNumeroAzar.setText("");
            }
        }else{
            if(this.vAvanzado.txtNumeroAzar.getText().equals(String.valueOf(numeroAdivinar))){
                this.vAvanzado.jopMensaje.showMessageDialog(vAvanzado, "Felicidades econtraste el numero\nGanaste 3 punto");
                puntos = puntos+3;
                this.usvo.setPunteoScore((puntos));
                this.usdao.cambiarPunteo(usvo);
                this.cambiarPunteo();
                this.vidas = 3;
                this.numeroAlAzar();
                this.vAvanzado.txtNumeroAzar.setText("");
            }else{
                this.vAvanzado.jopMensaje.showMessageDialog(vAvanzado, "Perdiste Vuelve a intentarlo\nEl numero era: "+numeroAdivinar);
                this.vAvanzado.txtNumeroAzar.setText("");
                this.vidas = 3;
                this.numeroAlAzar();
            }
        }
    }
    
    private void verificarPalabras(){
        traPalabra1 = this.traducir(palabra1);
        traPalabra2 = this.traducir(palabra2);
        traPalabra3 = this.traducir(palabra3);
        
        if(this.vAvanzado.txtPalabra1.getText().toLowerCase().equals(traPalabra1)){
            this.puntosJuego++;
        }
        if(this.vAvanzado.txtPalabra2.getText().toLowerCase().equals(traPalabra2)){
            this.puntosJuego++;
        }
        if(this.vAvanzado.txtPalabra3.getText().toLowerCase().equals(traPalabra3)){
            this.puntosJuego++;
        }
        this.vAvanzado.jopMensaje.showMessageDialog(vAvanzado, "Haz obtenido un cantidad de:"+this.puntosJuego+" puntos");
        this.palabrasAlAzar();
        this.puntos = puntos+puntosJuego;
        this.puntosJuego = 0;
        this.usvo.setPunteoScore((puntos));
        this.usdao.cambiarPunteo(usvo);
        this.cambiarPunteo();
        this.vAvanzado.txtPalabra1.setText("");
        this.vAvanzado.txtPalabra2.setText("");
        this.vAvanzado.txtPalabra3.setText("");
    }
    
    private void finalizarJuego(){
        int r = this.vAvanzado.jopMensaje.showConfirmDialog(vAvanzado, "Se reiniciara su punteo\n y regresara al nievel 1");
        if(r == this.vAvanzado.jopMensaje.YES_OPTION){
            this.vAvanzado.jopMensaje.showMessageDialog(vAvanzado, "felicidades usted ha ganada el Juego\n"+this.usvo.getNombreUsuario()+" "+this.usvo.getApellidoUsuario()+"\nPuntos: "+this.puntos);
            this.usvo.setFkIdTipoUsuario(2);
            this.usdao.subirNivel(usvo);
            this.usvo.setPunteoScore(0);
            this.usdao.cambiarPunteo(usvo);
            ControladorPrincipiante cprin = new ControladorPrincipiante(vMus, vInde, vAvanzado, usuario, vPrinci, usvo, usdao, vInte);
            this.vAvanzado.dispose();
            this.vPrinci.setVisible(true);
        }
    }
    
    private void modificarUsuario(){
        ControladorModificarUsuarioPropio cmup = new ControladorModificarUsuarioPropio(vMus, vInde, usvo, usdao);
        this.vAvanzado.dispose();
        this.vMus.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAvanzado.btnVerificarAdivinar){
            this.verificarAdivinar();
        }
        if(e.getSource() == this.vAvanzado.btnVerificarTraducir){
            this.verificarPalabras();
        }
        if(e.getSource() == this.vAvanzado.btnFinalizarJuego){
            this.finalizarJuego();
        }
        if(e.getSource() == this.vAvanzado.btnModificarUsuario){
            this.modificarUsuario();
        }
    }
    
}
