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
    
    
    

    public Estudiante(String nombre, String apellido, String usuario, String password) {
        super(nombre, apellido, usuario, password);
        this.puntajeExamen = -1; // -1 indica que aun no presenta examen
        this.clasificaciones = new HashMap<>(); 
       
    }
    
    public void notaMaterias(int mat,int soc,int ing,int bio,int leng){
        
        this.matematicas = mat;
        this.sociales = soc;
        this.ingles = ing;
        this.biologia = bio;
        this.lenguaje = leng;
        
    }
    
    public int getNota(String materia){ 
        switch(materia.toLowerCase()){// pasa las letras mayusculas a minusculas
            case "Matematicas" : return  matematicas;
            case "Lenguaje" : return   lenguaje;
            case "Biologia" : return biologia;
            case "Ingles" :return ingles;
            default: return -1;
        } 
    }
    
    public String getMateriaBaja(){
        String [] materias = {"Matematias","Lenguaje","Biologia","Ingles"};
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

    public void registrarExamen(int puntaje) {
    this.puntajeExamen = puntaje;
}

    
  
    
}
