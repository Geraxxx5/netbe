package modelo;

public interface ConsultasUsuarioScore {
    public String consultarDatos(String consulta, String usuario);
    public boolean existenciaTablaScore(UsuarioScoreVO usvo);
    public void crearTabla(int idUsuario);
    public String consultaDatosUsuario(String consulta, String usuario);
    public boolean cambiarPunteo(UsuarioScoreVO usvo);
    public boolean subirNivel(UsuarioScoreVO usvo);
    public boolean modificarUsuario(UsuarioScoreVO usvo);
}
