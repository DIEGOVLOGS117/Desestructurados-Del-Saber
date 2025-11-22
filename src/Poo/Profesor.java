package Poo;


public class Profesor extends Persona {

    private String especialidad;

    public Profesor(String nombre, String apellido, String email, String password, String especialidad) {
        super(nombre, apellido, email, password);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { // garantiza que el hasmap dectete que 
        // la clave de tipo String sea la relacionada a la matria 
        return especialidad;
    }
}