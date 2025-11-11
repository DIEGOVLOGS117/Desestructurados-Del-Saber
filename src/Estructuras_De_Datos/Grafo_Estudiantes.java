package Estructuras_De_Datos;

import java.util.*;
import Poo.*;

public class Grafo_Estudiantes {
    
    private Map<Estudiante, List<Estudiante>> listadeestudiantesconfalencia ; //
    private Map<String,Estudiante>profesores; //materia -> profesor 
    
    public Grafo_Estudiantes(){
    this.listadeestudiantesconfalencia = new HashMap<>();
    this.profesores = new HashMap<>();
   
}
            
    
   public void agregarEstudiante(Estudiante estudiantes){
        
        listadeestudiantesconfalencia.putIfAbsent(estudiantes,new ArrayList<>()); // si esta clave no existe en el mapa ,entonces agregala si ya esta no ahgas nada 
        
        
    }
    
    
    
    
    
    
    
}
