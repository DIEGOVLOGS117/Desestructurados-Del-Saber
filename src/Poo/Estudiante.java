package Poo;

import java.util.*;


public class Estudiante extends Persona {

    private int puntajeExamen;
    private Map<String,Integer> clasificaciones; // estrutura de dato clave valos 
    //materia -> nota
    
    
    

    public Estudiante(String nombre, String apellido, String usuario, String password) {
        super(nombre, apellido, usuario, password);
        this.puntajeExamen = -1; // -1 indica que aun no presenta examen
        this.clasificaciones = new HashMap<>(); 
    }
// falta meterle validacion al recivir los datos 
    public void registrarExamen(int puntaje) {
        this.puntajeExamen = puntaje;
    }

    public int getPuntajeExamen() {
        return puntajeExamen;
    }
    
    public void agregarCalificacion(String materia,int clasificacion){
        clasificaciones.put(materia,clasificacion);
    }
    
    
  
    
}
