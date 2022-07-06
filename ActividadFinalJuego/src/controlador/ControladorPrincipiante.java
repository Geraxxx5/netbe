package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vista.FrmPrincipiante;
import controlador.ControladorIndex;
import modelo.UsuarioScoreDAO;
import modelo.UsuarioScoreVO;
import vista.FrmAvanzado;
import vista.FrmIndex;
import vista.FrmIntermedio;
import vista.FrmModificarUsuario;

public class ControladorPrincipiante implements ActionListener, WindowListener{

    FrmPrincipiante vPrinci = new FrmPrincipiante();
    FrmIntermedio vInter = new FrmIntermedio();
    FrmAvanzado vAvanz = new FrmAvanzado();
    FrmIndex vInde = new FrmIndex();
    
    UsuarioScoreVO usvo = new UsuarioScoreVO();
    UsuarioScoreDAO usdao = new UsuarioScoreDAO();
    
    FrmModificarUsuario vMus = new FrmModificarUsuario();
    
    String usuario;
    
    int Sumar1;
    int Sumar12;
    int resultadoSuma1;
    
    int Sumar2;
    int Sumar22;
    int resultadoSuma2;
    
    int Restar1;
    int Restar12;
    int resultadoResta1;
    
    int Restar2;
    int Restar22;
    int resultadoResta2;
    
    int multi;
    int multi2;
    int resultadoMulti;
    
    Double divi;
    Double divi2;
    Double resultadoDivi;
    
    int puntos = 0;
    int puntosJuego = 0;
    
    public ControladorPrincipiante(FrmModificarUsuario vMus, FrmIndex vInde, FrmAvanzado vAvanz, String usuario, FrmPrincipiante vPrinci, UsuarioScoreVO usvo, UsuarioScoreDAO usdao, FrmIntermedio vInter){
        this.vPrinci = vPrinci;
        this.usuario = usuario;
        this.usvo = usvo;
        this.usdao = usdao;
        this.vInter = vInter;
        this.vAvanz = vAvanz;
        this.vInde = vInde;
        this.vMus = vMus;
        
        this.vPrinci.addWindowListener(this);
        this.vPrinci.btnVerificar.addActionListener(this);
        this.vPrinci.btnSalir.addActionListener(this);
        this.vPrinci.btnModificarUsuario.addActionListener(this);
        this.header();
    }
    
    private void header(){
        this.vPrinci.lblUsuario.setText(usuario);
        this.usvo.setUserUsuario(usuario);
        if(this.usdao.existenciaTablaScore(usvo)){
            this.puntos = Integer.parseInt(usdao.consultarDatos("punteo_score", usuario));
            this.vPrinci.lblPunteo.setText("Punteo: "+puntos);
            this.usvo.setApellidoUsuario(usdao.consultarDatos("apellido_usuario", usuario));
            this.usvo.setEdadUsuario(Integer.parseInt(usdao.consultarDatos("edad_usuario", usuario)));
            this.usvo.setIdUsuario(Integer.parseInt(usdao.consultarDatos("id_usuario", usuario)));
            this.usvo.setNombreUsuario(usdao.consultarDatos("nombre_usuario", usuario));
            this.usvo.setPassUsuario(usdao.consultarDatos("pass_usuario", usuario));
            this.usvo.setIdScore(Integer.parseInt(usdao.consultarDatos("id_score", usuario)));
        }
    }
    
    private void datosAleatorios(){
        this.puntosJuego = 0;
        this.Sumar1 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.Sumar12 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.vPrinci.lblSumar1.setText(String.valueOf(this.Sumar1));
        this.vPrinci.lblSumar12.setText(String.valueOf(this.Sumar12));
        
        this.Sumar2 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.Sumar22 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.vPrinci.lblSumar2.setText(String.valueOf(this.Sumar2));
        this.vPrinci.lblSumar22.setText(String.valueOf(this.Sumar22));
        
        this.Restar1 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.Restar12 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.vPrinci.lblRestar1.setText(String.valueOf(this.Restar1));
        this.vPrinci.lblRestar12.setText(String.valueOf(this.Restar12));
        
        this.Restar2 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.Restar22 = (int) Math.floor(Math.random()*(0-100+1)+100);
        this.vPrinci.lblRestar2.setText(String.valueOf(this.Restar2));
        this.vPrinci.lblRestar22.setText(String.valueOf(this.Restar22));
        
        this.multi = (int) Math.floor(Math.random()*(0-20+1)+20);
        this.multi2 = (int) Math.floor(Math.random()*(0-20+1)+20);
        this.vPrinci.lblMult1.setText(String.valueOf(this.multi));
        this.vPrinci.lblMult12.setText(String.valueOf(this.multi2));
        
        this.divi = Math.floor(Math.random()*(0-20+1)+20);
        this.divi2 = Math.floor(Math.random()*(1-20+1)+20);
        this.vPrinci.lblDivi1.setText(String.valueOf(this.divi));
        this.vPrinci.lblDivi12.setText(String.valueOf(this.divi2));
    }
    

    
    private void validar(){
        //Long r = Math.round(((Double.parseDouble(String.valueOf(this.divi))/Double.parseDouble(String.valueOf(this.divi2)))));
        puntosJuego = 0;
        Double r = (this.divi / this.divi2);
        String aja = r.toString().substring(0, 3);
        if(this.vPrinci.txtSumar1.getText().equals(String.valueOf((this.Sumar1+this.Sumar12)))){
            this.puntosJuego ++;
        }
        if(this.vPrinci.txtSumar2.getText().equals(String.valueOf((this.Sumar2+this.Sumar22)))){
            this.puntosJuego++;
        }
        if(this.vPrinci.txtRestar1.getText().equals(String.valueOf((this.Restar1 - this.Restar12)))){
            this.puntosJuego++;
        }
        if(this.vPrinci.txtRestar2.getText().equals(String.valueOf((this.Restar2 - this.Restar22)))){
            this.puntosJuego++;
        }
        if(this.vPrinci.txtMult1.getText().equals(String.valueOf((this.multi * this.multi2)))){
            this.puntosJuego++;
        }
        if(this.vPrinci.txtDivisi1.getText().equals(aja)){
            this.puntosJuego++;
        }
        puntos = puntos+puntosJuego;
        this.usvo.setPunteoScore((puntos));
        this.usdao.cambiarPunteo(usvo);
        if(!(puntos >= 30)){
            this.vPrinci.jopMensaje.showMessageDialog(vPrinci, "Ha logrado obtener una cantidad de "+this.puntosJuego+" puntos");
            this.cambiarPunteo();
            this.vPrinci.txtDivisi1.setText("");
            this.vPrinci.txtMult1.setText("");
            this.vPrinci.txtRestar1.setText("");
            this.vPrinci.txtRestar2.setText("");
            this.vPrinci.txtSumar1.setText("");
            this.vPrinci.txtSumar2.setText("");
        }else{
            subirNivel();
        }
    }
    
    private void cambiarPunteo(){
        this.vPrinci.lblPunteo.setText("Punteo: "+puntos);
        
    }
    
    private void subirNivel(){
        this.vPrinci.jopMensaje.showMessageDialog(vPrinci, "Felicidades subiste de nivel! alcanzaste un punteo de 30 o mas");
        this.usvo.setFkIdTipoUsuario(3);
        this.usdao.subirNivel(usvo);
        this.vPrinci.dispose();
        ControladorIntermedio cInter = new ControladorIntermedio(vMus, vInde, vPrinci, vAvanz, usuario, vInter, usvo, usdao);
        this.vInter.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vPrinci.btnVerificar){
            this.validar();
        }
        if(e.getSource() == this.vPrinci.btnSalir){
            System.exit(0);
        }
        if(e.getSource() == this.vPrinci.btnModificarUsuario){
            this.modificarUsuario();
        }
    }
    
    private void modificarUsuario(){
        ControladorModificarUsuarioPropio cmup = new ControladorModificarUsuarioPropio(vMus, vInde, usvo, usdao);
        this.vPrinci.dispose();
        this.vMus.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.datosAleatorios();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
