package modelo;

import java.util.ArrayList;

public interface ConsultasUsuario {
    public int verificacion(UsuarioVO uvo);
    public boolean ingresarUsuario(UsuarioVO uvo);
    public ArrayList<UsuarioVO> datosTabla();
    public boolean borrar(UsuarioVO uvo);
    public boolean actualizar(UsuarioVO uvo);
    public boolean vereficarExistencia(UsuarioVO uvo);
    public int getId(UsuarioVO uvo);
    public void reporte();
}
