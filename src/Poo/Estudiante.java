package Poo;


public class Estudiante extends Persona {

    private int puntajeExamen;

    public Estudiante(String nombre, String apellido, String usuario, String password) {
        super(nombre, apellido, usuario, password);
        this.puntajeExamen = -1; // -1 indica que aun no presenta examen
    }

    public void registrarExamen(int puntaje) {
        this.puntajeExamen = puntaje;
    }

    public int getPuntajeExamen() {
        return puntajeExamen;
    }
}
