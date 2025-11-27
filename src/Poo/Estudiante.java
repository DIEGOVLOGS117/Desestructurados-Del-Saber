package Poo;

import java.util.*;


public class Estudiante extends Persona {
    
    private int matematicas;
    private int lenguaje;
    private int biologia;
    private int ingles;
    private int sociales;
    

    private int puntajeExamen;
    private Map<String,Integer> clasificaciones; // estrutura de dato clave valos 
    //materia -> nota
    
    public Estudiante(String nombre) {
        super(nombre);
        this.puntajeExamen = -1; // -1 indica que aun no presenta examen
        this.clasificaciones = new HashMap<>(); 
       
    }
    
    public void notaMaterias(int matematicas,int sociales,int ingles,int biologia,int lenguaje){
        
        this.matematicas = matematicas;
        this.sociales = sociales;
        this.ingles = ingles;
        this.biologia = biologia;
        this.lenguaje = lenguaje;
        
    }
    
    public int getNota(String materia){ 
    // Corregido: Los casos del switch deben estar en minúsculas
    // porque la variable 'materia' se convierte a minúsculas (.toLowerCase())
    switch(materia.toLowerCase()){
        case "matematicas" : return  matematicas;
        case "lenguaje" : return   lenguaje;
        case "biologia" : return biologia;
        case "ingles" :return ingles;
        case "sociales" : return sociales; // Añadido para completar el set
        default: return -1;
    } 
}
    
    public String getMateriaBaja(){ // analisa todas las notas de las aterias y devuelve la materia en la que peor le fue 
        String [] materias = {"Matematicas","Lenguaje","Biologia","Ingles"};
        String materiaBaja = "" ;
        int notaMinima = 101; // recorremos hacia atras los puntajes 
        
        for(String materia:materias){
            int nota = getNota(materia);// da el valor de esa nota de esa materia
            if(nota != -1 && nota <notaMinima){ // compara todas las notas
                notaMinima = nota;
                materiaBaja= materia;
            }
            
        }
        return materiaBaja;// muestra la materia ocn la nota mas baja 
        
    }
    
// falta meterle validacion al recivir los datos 
//    public void registrarExamen(int puntaje) {
//        this.puntajeExamen = puntaje;
//    }

    public int getPuntajeExamen() {
        return puntajeExamen;
    }
    
    public void agregarCalificacion(String materia,int clasificacion){
        clasificaciones.put(materia,clasificacion);
    }
    
    
  
    
}
