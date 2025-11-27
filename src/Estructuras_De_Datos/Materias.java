package Estructuras_De_Datos;

import java.util.ArrayList;
import java.util.List;

public class Materias {
    
    private ArrayList<Integer> notas = new ArrayList<>();
    private ArrayList<String> nombreMateria = new ArrayList<>();
    
    private String materiaMasBaja; 
    
    private int mates;
    private int ingles;
    private int biologia;
    private int sociales;
    private int lectura;
    
    // Orden fijo de materias
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
         
        this.materiaMasBaja = "Ninguna"; // por si no pierde ninguna
    }
         
    public void materiasPerdidas(){
         
        int notaMasBaja = 101; 
        String materiaMasBajaTemp = null;
         
        for(int i = 0; i < notas.size(); i++){
            int notaActual = notas.get(i);
             
            if(notaActual < 70){ // condición para que repruebe 
                 
                // Lista de todas las materias reprobadas 
                nombreMateria.add(materias[i]); 
                 
                if(notaActual < notaMasBaja){
                    notaMasBaja = notaActual;
                    materiaMasBajaTemp = materias[i];
                }
            }
        }
        
        // Actualizamos el atributo real
        if (materiaMasBajaTemp != null) {
            this.materiaMasBaja = materiaMasBajaTemp;
        } else {
            this.materiaMasBaja = "Ninguna";
        }
    }
     
    public String getMateriaMasBaja(){
        return this.materiaMasBaja;
    }
    
    public java.util.List<String> getMateriasPerdidas() {
        return nombreMateria;
    }

}