
package Estructuras_De_Datos;

import java.util.ArrayList;

public class Materias {
    
    ArrayList<Integer> notas = new ArrayList<>();
    ArrayList<String> nombreMateria = new ArrayList<>();
    
    private int mates;
    private int ingles;
    private int biologia;
    private int sociales;
    private int lectura;
    
    private String[] materias = {"Matemáticas", "Inglés", "Biología", "Sociales", "Lectura"};
            
     public Materias(int mates,int ingles, int biologia , int sociales, int lectura){
         
         this.mates = mates;
         this.ingles = ingles;
         this.biologia = biologia;
         this.sociales = sociales;
         this.lectura = lectura;
         
         
         notas.add(mates);
         notas.add(ingles);
         notas.add(biologia);
         notas.add(sociales);
         notas.add(lectura);
         
         
         
     }
         
     
     
     
     public void materiasPerdidas(){
         
         for(int i =0; i < notas.size(); i++){
             if(notas.get(i)>70){
             
         }else{
                 
                 nombreMateria.add(materias[i]);
                 
                 }
         }
         
         
     }
            
    
}
