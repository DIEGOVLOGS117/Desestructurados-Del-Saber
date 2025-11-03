
package Estructuras_De_Datos.ListaSimple;

import Estructuras_De_Datos.Grafos;

public class Lista {
    private Nodo cabeza; 
    private int tamano;
    
    public Lista(){
        this.cabeza= null; 
        this.tamano= 0; 
         
    }
    
     public void insertarNodoInicio(Grafos dato){
        Nodo nodoIni = new Nodo(dato);
        nodoIni.siguiente = cabeza; 
        cabeza = nodoIni; 
        tamano++;
    }
     
     public void insertarNodoFinal(Grafos dato){
         Nodo nodoFin = new Nodo(dato);
         Nodo nodoRecorre = cabeza; // hise una copia 
         
         while (nodoRecorre.siguiente != null){
             nodoRecorre = nodoRecorre.siguiente;
         }
         
         nodoRecorre.siguiente = nodoFin;
         tamano++;
     }
     
     public void insertarNodoIndice(Grafos dato,int posicion ){ // insear nodo en un indice 
        
         Nodo nodoIndice = new Nodo(dato);
         Nodo nodoRecorre = cabeza;
         
         int cont = 0;
         while (cont <(posicion-1) && nodoRecorre.siguiente != null){
             nodoRecorre = nodoRecorre.siguiente; 
             cont ++;
         }
         if(cont == (posicion-1)){
         nodoIndice.siguiente = nodoRecorre.siguiente;
         nodoRecorre.siguiente = nodoIndice;
         tamano++;
         }
}
     public void imprimirLista(){
         Nodo nodoRecorre = cabeza; 
         
         while (nodoRecorre != null){
             System.out.println(nodoRecorre.dato + "->");
             nodoRecorre = nodoRecorre.siguiente;
         }
         System.out.println("NULL");
     }
     
     //Ahorrar memoria borrando las copaias hechas 
     public void eliminarNodoInicio(){
         Nodo inicio = cabeza; 
         cabeza = inicio.siguiente;
         inicio.siguiente = null; //romper el enlace
         tamano--;
     }

    public int getTamano() {
        return tamano;
    }
     
     
     public void eliminarNodoFinal(){
         if (cabeza.siguiente == null){
         cabeza=null;
     }else{
             Nodo nodoRecorre = cabeza;
             
             while(nodoRecorre.siguiente.siguiente != null){
                 nodoRecorre = nodoRecorre.siguiente;
             }
             nodoRecorre.siguiente = null; // se elimina el nodo 
         }
         tamano--;
     }
     
     public void eliminarIndice(int posicion){
         
         
         Nodo nodoRecorre = cabeza;
         
         int cont = 0;
         while (cont <(posicion-1) && nodoRecorre.siguiente != null){
             nodoRecorre = nodoRecorre.siguiente; 
             cont ++;
             
         }
         
         Nodo aux = nodoRecorre.siguiente; // nodo a eliminar, creamos una copia del nodo 
         nodoRecorre.siguiente = aux.siguiente;// saltamos al otro nodo que queremos que se balla 
         aux.siguiente = null; //romper el enlace , eliminamos el nodo
         
         tamano--;
     }

     public void buscador(int indice){
        
         if(indice == 0 || indice >= tamano){
             System.out.println("Eror al ingresar datos");
             return;
         }
         
         if(indice == 0){
             System.out.println("En el inidce 0 o el primer nodo se encuentra el dato" + cabeza.dato);
             }else{
             int cont =0;
             Nodo recorre = cabeza;
             while(cont< indice){
                 recorre = recorre.siguiente; // recorre la lista
                 cont ++;
                 break;
             }
             System.out.println("El dato que se encuentra en el indice " + indice + " es: " + recorre.dato);
            
         }
     }
         
     public void buscadorDeGrafos(Grafos valor){
         // implementar en que posicion se encuentra ese valor terminar para la casa 
//        boolean vrificador = false;
         Nodo recorre = cabeza;
         int cont = 0;
       
          while (recorre != null){
            if(recorre.dato == valor ){
                System.out.println("Si hay un numero en la lista"+ "El dato es: " + recorre.dato + "posicion");
                break;
            }else{
            recorre = recorre.siguiente;}
            cont ++;
            break;
           
        
       }
     }
     
     public void eliminarDuplicados(){
         
         //Nota pendiente explicar mi codigo conceptual mente.
         
         Nodo recorre = cabeza;
      
         //se ejecuta si el nodo no esta basio y el siguiente tampoco esta basio
         while(recorre != null && recorre.siguiente != null){
             //si el dato de ese nodo es igual al del siguiente 
             if(recorre.dato ==  recorre.siguiente.dato){
                 
                 Nodo aux = recorre.siguiente;// nodo a eliminar, creamos una copia del nodo
                 recorre.siguiente = aux.siguiente;// saltamos al otro nodo que queremos que se balla 
                 aux.siguiente = null;//romper el enlace , eliminamos el nodo
                 tamano--;
                 
             }else {
                 recorre = recorre.siguiente; // salta al siguiente nodo
             }
         }
     }
             
}
