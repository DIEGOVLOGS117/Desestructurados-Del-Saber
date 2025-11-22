
package Estructuras_De_Datos;

import java.util.*;
import Poo.Estudiante;
import Poo.Profesor;



public class Area51 {
    
    public static void main(String[] args) {
        
        List<Estudiante> estudiantes = Arrays.asList( // creo una lista de estudiantes 
            new Estudiante("Ana","a","a","a"),   // Falencia: Lenguaje (55)
            new Estudiante("Beto", "b","b","b"),  // Falencia: Ciencias (45)
            new Estudiante("Carla", "c","c","c"), // Falencia: Lenguaje (50)
            new Estudiante("David", "d","d","d"), // Falencia: Historia (50)
            new Estudiante("Elena", "e","e","e")  // Falencia: Matemáticas (50)
        );
        
        for(Estudiante e : estudiantes){
            e.notaMaterias(20, 30, 40, 60, 100);
            
        }

        // 2. Creo la lista de profesores 
        List<Profesor> profesores = Arrays.asList(
            new Profesor("Profe. Laura","","","", "Lenguaje"),
            new Profesor("Profe. Miguel","","","", "Ciencias"),
            new Profesor("Profe. Sofía","","","", "Historia"),
            new Profesor("Profe. Gómez","","","", "Matemáticas")
        );

        // 3. CONSTRUCCIÓN Y ANÁLISIS DEL GRAFO
        GrafoTutoria proyecto = new GrafoTutoria();
        proyecto.configurarProfesores(profesores);
        proyecto.construirGrafo(estudiantes);
        
        // 4. RESULTADO
        proyecto.mostrarAsignaciones();
    }
        
    }
            


