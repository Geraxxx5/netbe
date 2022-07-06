package modelo;

public class UsuarioVO {
    int idUsuario;
    String nombreUsuario;
    String apellidoUsuario;
    int edadUsuario;
    String userUsuario;
    String passUsuario;
    int fkIdEstado;
    int fkIdTipoUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public int getFkIdEstado() {
        return fkIdEstado;
    }

    public void setFkIdEstado(int fkIdEstado) {
        this.fkIdEstado = fkIdEstado;
    }

    public int getFkIdTipoUsuario() {
        return fkIdTipoUsuario;
    }

    public void setFkIdTipoUsuario(int fkIdTipoUsuario) {
        this.fkIdTipoUsuario = fkIdTipoUsuario;
    }
    
}
