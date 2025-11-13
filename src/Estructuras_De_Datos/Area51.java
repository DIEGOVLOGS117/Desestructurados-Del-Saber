
package Estructuras_De_Datos;

import java.util.*;
import Poo.Estudiante;



public class Area51 {
    
    public static void main(String[] args) {
        
        List<Estudiante> estudiantes = Arrays.asList(
            new Estudiante("Ana","a","a","a",85, 55, 70, 65),   // Falencia: Lenguaje (55)
            new Estudiante("Beto", 60, 75, 45, 80),  // Falencia: Ciencias (45)
            new Estudiante("Carla", 70, 50, 90, 75), // Falencia: Lenguaje (50)
            new Estudiante("David", 95, 65, 80, 50), // Falencia: Historia (50)
            new Estudiante("Elena", 50, 80, 70, 90)  // Falencia: Matemáticas (50)
        );

        // 2. DATOS DE PROFESORES
        List<Profesor> profesores = Arrays.asList(
            new Profesor("Profe. Laura", "Lenguaje"),
            new Profesor("Profe. Miguel", "Ciencias"),
            new Profesor("Profe. Sofía", "Historia"),
            new Profesor("Profe. Gómez", "Matemáticas")
        );

        // 3. CONSTRUCCIÓN Y ANÁLISIS DEL GRAFO
        GrafoTutoria proyecto = new GrafoTutoria();
        proyecto.configurarProfesores(profesores);
        proyecto.construirGrafo(estudiantes);
        
        // 4. RESULTADO
        proyecto.mostrarAsignaciones();
    }
        
    }
            
   
}
