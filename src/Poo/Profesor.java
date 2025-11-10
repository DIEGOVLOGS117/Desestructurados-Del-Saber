package Poo;


public class Profesor extends Persona {

    private String especialidad;

    public Profesor(String nombre, String apellido, String usuario, String password, String especialidad) {
        super(nombre, apellido, usuario, password);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}