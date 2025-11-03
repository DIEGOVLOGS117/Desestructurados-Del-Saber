package Estructuras_De_Datos;

import  Estructuras_De_Datos.ListaSimple.*;

public class Asignacion {
    
    //Se guardan todas las personas 
     private Lista listaDePersonas; // lista simple 
     
    public Asignacion() {
    this.listaDePersonas= new Lista();
}
    
    Materias resultados = new Materias(30,46,57,34,89);
    
    public void materiasPerdidas(Materias resultados){
        
        if(resultados.)
        
    }
    
    

    
    public void agregarEstudiantes(String nombre, Materias falencia){
        Grafos nuevoEstudiante  = new Grafos(nombre,"Estudiante",falencia);
        listaDePersonas.insertarNodoFinal(nuevoEstudiante);
        
        //ver como implementar este codigo sin que se rompa todo el codigo de la lista simple 
    }
    
    public void agregarProfesor(String nombre, Materias materia ){
        Grafos nuevoProfesor = new Grafos (nombre, "Profesor",materia);
        listaDePersonas.insertarNodoFinal(nuevoProfesor);
        
        
    }
    
    
    
}
