package Interfaz_Grafica;

public class UsuarioPlataform {
    
    private String nombreUsuario;
    private String contraseUsuario;
    private String emailUsuario;
    private String idUsuario;

    public UsuarioPlataform() {
    }

    public UsuarioPlataform(String nombreUsuario, String contraseUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseUsuario = contraseUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseUsuario() {
        return contraseUsuario;
    }

    public void setContraseUsuario(String contraseUsuario) {
        this.contraseUsuario = contraseUsuario;
    }
    
    public boolean validacionDatosUsuario(String nombreUsuario, String contraseUsuario) {
        if(this.nombreUsuario == null || this.contraseUsuario == null)
            return false;
    return this.nombreUsuario.equals(nombreUsuario) && this.contraseUsuario.equals(contraseUsuario);
    }

}
