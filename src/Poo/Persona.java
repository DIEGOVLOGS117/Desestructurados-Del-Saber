package Poo;

public class Persona {
    protected String nombre;
    protected String apellido;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}    