package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioScoreDAO;
import modelo.UsuarioScoreVO;
import vista.FrmAvanzado;
import vista.FrmIndex;
import vista.FrmIntermedio;
import vista.FrmModificarUsuario;
import vista.FrmPrincipiante;

public class ControladorIntermedio implements ActionListener{

    FrmIntermedio vInterm = new FrmIntermedio();
    UsuarioScoreVO usvo = new UsuarioScoreVO();
    UsuarioScoreDAO usdao = new UsuarioScoreDAO();
    
    FrmAvanzado vAvanz = new FrmAvanzado();
    FrmPrincipiante vPrin = new FrmPrincipiante();
    FrmIndex vInde = new FrmIndex();
    FrmModificarUsuario vMus = new FrmModificarUsuario();
    int puntos = 0;
    int puntosJuego = 0;
    String usuario;
    
    public ControladorIntermedio(FrmModificarUsuario vMus, FrmIndex vInde, FrmPrincipiante vPrin, FrmAvanzado vAvanz, String usuario, FrmIntermedio vInterm, UsuarioScoreVO usvo, UsuarioScoreDAO usdao){
        this.vInterm = vInterm;
        this.usuario = usuario;
        this.usvo = usvo;
        this.usdao = usdao;
        this.vAvanz = vAvanz;
        this.vPrin = vPrin;
        this.vInde = vInde;
        this.vMus = vMus;
        
        this.vInterm.bgHimno.add(this.vInterm.rbHimnoCorrecto);
        this.vInterm.bgHimno.add(this.vInterm.rbHimnoMalo);
        this.vInterm.bgHimno.add(this.vInterm.rbHimnoMalo2);
        
        this.vInterm.bgIndependencia.add(this.vInterm.rbIndependenciaBueno);
        this.vInterm.bgIndependencia.add(this.vInterm.rbIndependenciaMalo);
        this.vInterm.bgIndependencia.add(this.vInterm.rbIndependenciaMalo2);
        
        this.vInterm.bgFlor.add(this.vInterm.rbFlorBuena);
        this.vInterm.bgFlor.add(this.vInterm.rbFlorMala);
        this.vInterm.bgFlor.add(this.vInterm.rbFlorMala2);
        
        this.vInterm.bgArbol.add(this.vInterm.rbArbolCorrecto);
        this.vInterm.bgArbol.add(this.vInterm.rbArbolMalo);
        this.vInterm.bgArbol.add(this.vInterm.rbArbolMalo2);
        
        this.vInterm.bgAve.add(this.vInterm.rbAveBueno);
        this.vInterm.bgAve.add(this.vInterm.rbAveMalo);
        this.vInterm.bgAve.add(this.vInterm.rbAveMalo2);
        
        this.vInterm.btnSalir.addActionListener(this);
        this.vInterm.btnVerificar.addActionListener(this);
        this.vInterm.btnModificarUsuario.addActionListener(this);
        
        this.header();
    }
    
    private void header(){
        this.vInterm.lblUsuario.setText(usuario);
        this.usvo.setUserUsuario(usuario);
        if(this.usdao.existenciaTablaScore(usvo)){
            this.puntos = Integer.parseInt(usdao.consultarDatos("punteo_score", usuario));
            this.vInterm.lblPunteo.setText("Punteo: "+puntos);
            this.usvo.setApellidoUsuario(usdao.consultarDatos("apellido_usuario", usuario));
            this.usvo.setEdadUsuario(Integer.parseInt(usdao.consultarDatos("edad_usuario", usuario)));
            this.usvo.setIdUsuario(Integer.parseInt(usdao.consultarDatos("id_usuario", usuario)));
            this.usvo.setNombreUsuario(usdao.consultarDatos("nombre_usuario", usuario));
            this.usvo.setPassUsuario(usdao.consultarDatos("pass_usuario", usuario));
            this.usvo.setIdScore(Integer.parseInt(usdao.consultarDatos("id_score", usuario)));
        }
    }
    
    private void cambiarPunteo(){
        this.vInterm.lblPunteo.setText("Punteo: "+puntos);
    }
    
    public void verificar(){
        try {
            if(this.vInterm.bgHimno.getSelection().equals(this.vInterm.rbHimnoCorrecto.getModel())){
                this.puntosJuego++;
            }
            if(this.vInterm.bgArbol.getSelection().equals(this.vInterm.rbArbolCorrecto.getModel())){
                this.puntosJuego++;
            }
            if(this.vInterm.bgAve.getSelection().equals(this.vInterm.rbAveBueno.getModel())){
                this.puntosJuego++;
            }
            if(this.vInterm.bgFlor.getSelection().equals(this.vInterm.rbFlorBuena.getModel())){
                this.puntosJuego++;
            }
            if(this.vInterm.bgIndependencia.getSelection().equals(this.vInterm.rbIndependenciaBueno.getModel())){
                this.puntosJuego++;
            }
            puntos = puntos+puntosJuego;
            this.usvo.setPunteoScore((puntos));
            this.usdao.cambiarPunteo(usvo);
            if(!(puntos >= 65)){
                this.vInterm.jopMensaje.showMessageDialog(vInterm, "Haz obtenido un cantidad de: "+this.puntosJuego+" puntos");

                this.vInterm.bgArbol.clearSelection();
                this.vInterm.bgAve.clearSelection();
                this.vInterm.bgFlor.clearSelection();
                this.vInterm.bgHimno.clearSelection();
                this.vInterm.bgIndependencia.clearSelection();

                this.cambiarPunteo();
                this.puntosJuego = 0;
            }else{
                this.subirNivel();
            }
        } catch (Exception e) {
            this.vInterm.jopMensaje.showMessageDialog(vInterm, "Seleccione todos los campos");
        }
    }
    
    private void subirNivel(){
        this.vInterm.jopMensaje.showMessageDialog(vInterm, "Felicidades subiste de nivel! alcanzaste un punteo de 65 o mas");
        this.usvo.setFkIdTipoUsuario(4);
        this.usdao.subirNivel(usvo);
        ControladorAvanzado cavanza = new ControladorAvanzado(vMus, vInde, vInterm, vPrin, usuario, vAvanz, usvo, usdao);
        this.vInterm.dispose();
        this.vAvanz.setVisible(true);
    }

    private void modificarUsuario(){
        ControladorModificarUsuarioPropio cmup = new ControladorModificarUsuarioPropio(vMus, vInde, usvo, usdao);
        this.vInterm.dispose();
        this.vMus.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vInterm.btnSalir){
            System.exit(0);
        }
        if(e.getSource() == this.vInterm.btnVerificar){
            this.verificar();
        }
        if(e.getSource() == this.vInterm.btnModificarUsuario){
            this.modificarUsuario();
        }
    }

}
