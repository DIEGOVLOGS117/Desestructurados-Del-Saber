package Poo;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String password;

    public Persona(String nombre, String apellido, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}    

