
package Estructuras_De_Datos;

import java.util.*;
import Poo.Estudiante;
import Poo.Profesor;



public class Area51 {
    
    public static void main(String[] args) {
        
        System.out.println("--- 1. INICIALIZACIÓN DE DATOS ---");

        // 1. DATOS DE ESTUDIANTES Y ASIGNACIÓN DE NOTAS
        // NOTA: La firma es: (mat, soc, ing, bio, leng)
        List<Estudiante> estudiantes = Arrays.asList( 
            // Falencia es la nota más baja de {mat, leng, bio, ing}
            new Estudiante("Ana"),     
            new Estudiante("Beto"),    
            new Estudiante("Carla"),  
            new Estudiante("David") 
        );
        
        // Se asignan notas diferentes para generar falencias distintas:
        estudiantes.get(0).notaMaterias(80, 75, 60, 70, 50); // Ana: Falencia es 50 (Lenguaje)
        estudiantes.get(1).notaMaterias(30, 75, 60, 70, 50); // Beto: Falencia es 30 (Matematicas)
        estudiantes.get(2).notaMaterias(85, 75, 60, 70, 45); // Carla: Falencia es 45 (Lenguaje)
        estudiantes.get(3).notaMaterias(80, 75, 40, 70, 50); // David: Falencia es 40 (Ingles)


        // 2. DATOS DE PROFESORES
        List<Profesor> profesores = Arrays.asList(
        new Profesor("Profe. Laura", "Lenguaje"),
        new Profesor("Profe. Miguel", "Ciencias"),
        new Profesor("Profe. Sofía", "Historia"),
        new Profesor("Profe. Gómez", "Matematicas"),
        new Profesor("Profe. María", "Ingles")
        );

//        // 3. CONSTRUCCIÓN DEL GRAFO
//        GrafoTutoria proyecto = new GrafoTutoria();
//        proyecto.configurarProfesores(profesores); // Conecta Materia -> Profesor (1:1)
//        proyecto.construirGrafo(estudiantes);      // Conecta Estudiante -> Materia (N:1)
//        
//        
//        // --- 4. PRUEBAS DE FUNCIONAMIENTO ---
//        System.out.println("\n--- 4. PRUEBAS DEL MÉTODO mostrarGrafoPorMateria ---");
//        
//        // PRUEBA 1: Materia con más de un estudiante (Ana y Carla)
//        System.out.println("\n*** PRUEBA 1: Buscando el Grafo 'Lenguaje' ***");
//        proyecto.mostrarGrafoPorMateria("Lenguaje");
//        
//        // PRUEBA 2: Materia con un único estudiante (Beto)
//        System.out.println("\n*** PRUEBA 2: Buscando el Grafo 'Matematicas' ***");
//        proyecto.mostrarGrafoPorMateria("Matematicas");
//        
//        // PRUEBA 3: Materia que no es falencia para nadie (Debe mostrar error)
//        System.out.println("\n*** PRUEBA 3: Buscando el Grafo 'Biologia' ***");
//        proyecto.mostrarGrafoPorMateria("Biologia");
    }        
    }
            


