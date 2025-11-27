package Poo;


public class Profesor extends Persona {

    private String especialidad;

    public Profesor(String nombre,String especialidad) {
        super(nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { // garantiza que el hasmap dectete que 
        // la clave de tipo String sea la relacionada a la matria 
        return especialidad;
    }
}