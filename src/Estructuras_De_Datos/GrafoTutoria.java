
package Estructuras_De_Datos;

import java.util.*;
import Poo.Estudiante;
import Poo.Profesor;

public class GrafoTutoria {
    
    private Map<String,List<Estudiante>> estudiantesPorFalencia;
    
    //Tener en cuenta la actualización en dado caso de que una persona tenga el mismo puntaje en unas materias
    //String recibe el nombre de la materia 
    //retorna lo que esta almacenado en al lista con ese nombre
    //es decir si el string fuera matematicas reotrnaria todos los estudiantes con falencias en matematicas
    
    private Map<String,Profesor> asignacionProfesor;
    
    // Key: Falencia (Materia)
    // Value: Profesor asignado a esa materia
    
    public GrafoTutoria(){
        this.asignacionProfesor= new HashMap<>();
        this.estudiantesPorFalencia = new HashMap <>();
        
        
        
    }
    
    
    public void configurarprofesor(List<Profesor> profesores ){
        for(Profesor p: profesores){
            asignacionProfesor.put(p.getEspecialidad(),p);
            //.put(clave, valor);
        }
    }
    
    // terminar de codifiar esta fucnion
    
    public void construirGrafo(List<Estudiante> estudiantes) {
        for (Estudiante e : estudiantes) {
            String falencia = e.getMateriaBaja();
            
            // Si la falencia (nodo) no existe, se inicializa su lista
            if (!estudiantesPorFalencia.containsKey(falencia)) {
                estudiantesPorFalencia.put(falencia, new ArrayList<>());
            }
            
            // Conecta el estudiante a la falencia (añadir a la lista)
            estudiantesPorFalencia.get(falencia).add(e);
        }
    }

    /**
     * Muestra la estructura final del grafo y las asignaciones de tutoría.
     */
    public void mostrarAsignaciones() {
        System.out.println("==================================================");
        System.out.println("       ESTRUCTURA DEL GRAFO DE TUTORÍA");
        System.out.println("==================================================");

        // Iterar sobre las materias (los nodos centrales del grafo)
        for (String falencia : estudiantesPorFalencia.keySet()) {
            List<Estudiante> estudiantes = estudiantesPorFalencia.get(falencia);
            Profesor profesorAsignado = asignacionProfesor.get(falencia);

            // 1. Mostrar el nodo central (Falencia/Materia)
            System.out.println("\n▶ FALENCIA GRUPAL: " + falencia.toUpperCase());
            System.out.println("--------------------------------------------------");

            // 2. Mostrar la conexión Materia -> Profesor
            if (profesorAsignado != null) {
                System.out.println("  ASIGNADO A PROFESOR: " + profesorAsignado.getNombre());
            } else {
                System.out.println("  ⚠️ ERROR: No hay profesor asignado para " + falencia);
            }

            // 3. Mostrar las conexiones Estudiante -> Materia (el grupo)
            System.out.print("  ESTUDIANTES ASIGNADOS (" + estudiantes.size() + "): ");
            
            List<String> nombres = new ArrayList<>();
            for (Estudiante e : estudiantes) {
                nombres.add(e.getNombre());
            }
            System.out.println(String.join(", ", nombres));
        }
    
    
}

    public void configurarProfesores(List<Profesor> profesores) {
        // Itera sobre la lista de profesores que le pasamos desde el main
        for (Profesor p : profesores) {
            // Usa la especialidad del profesor (ej. "Lenguaje") como clave
            // y el objeto Profesor (ej. Profe. Laura) como valor.
            asignacionProfesor.put(p.getEspecialidad(), p);
        }
    }
    
}