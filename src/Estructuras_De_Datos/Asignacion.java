package Estructuras_De_Datos;

import  Estructuras_De_Datos.ListaSimple.*;

public class Asignacion {
    
    //Se guardan todas las personas 
     private Lista listaDePersonas;
     
    public Asignacion() {
    this.listaDePersonas= new Lista();
}
    
    public void agregarEstudiantes(String nombre, String falencia){
        Grafos nuevoEstudiante  = new Grafos(nombre,"Estudiante",falencia);
        listaDePersonas.insertarNodoFinal(nuevoEstudiante);
        
        //ver como implementar este codigo sin que se rompa todo el codigo de la lista simple 
    }
    
    
    
    
}
