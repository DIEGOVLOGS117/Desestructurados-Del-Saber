
package Estructuras_De_Datos;

import java.util.ArrayList;

public class Materias {
    
    ArrayList<Integer> notas = new ArrayList<>();
    ArrayList<String> nombreMateria = new ArrayList<>();
    
    private String materiaMasBaja; 
    
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
         
         this.materiaMasBaja = "Ninguna"; // por si hay un estudiante que haya pasado todo 
         
     }
         
     public void materiasPerdidas(){
         
         int notaMasBaja = 101; 
         String materiaMasBajaTemp = null;
         
         for(int i =0; i < notas.size(); i++){
             int notaActual = notas.get(i);
             
             if(notaActual < 70){ // codicion para que reprueben 
                 
                 nombreMateria.add(materias[i]); // lista de todas las materias reprobadas 
                 if(notaActual < notaMasBaja){
                     notaMasBaja = notaActual;
                     materiaMasBajaTemp = materias[i];
                 }
             

        
     
             }
         }
     }
     
     
     
     public String getMateriaMasBaja(){
                return this.materiaMasBaja;
            }
}
