
package Estructuras_De_Datos.ListaSimple;

import Estructuras_De_Datos.Grafos; //solo importo la clase 

public class Nodo {
    public Grafos dato;
    public Nodo siguiente = null;
    
    
    public Nodo(Grafos dato){
        this.dato = dato; 
    }
}
