package Estructuras_De_Datos;

import java.util.*;
import Poo.Estudiante;
import Poo.Profesor;

public class GrafoTutoria {
    
    // Key: nombre de la materia con falencia
    // Value: lista de estudiantes que tienen esa falencia
    private Map<String, List<Estudiante>> estudiantesPorFalencia;

    // Key: materia
    // Value: profesor asignado a esa materia
    private Map<String, Profesor> asignacionProfesor;
    
    public GrafoTutoria() {
        this.asignacionProfesor = new HashMap<>();
        this.estudiantesPorFalencia = new HashMap<>();
    }
    
    public void construirGrafo(List<Estudiante> estudiantes) {
        for (Estudiante e : estudiantes) {
            // materia más baja del estudiante
            String falencia = e.getMateriaBaja(); 
            
            // Si la materia aún no tiene lista, la creamos
            if (!estudiantesPorFalencia.containsKey(falencia)) {
                estudiantesPorFalencia.put(falencia, new ArrayList<>());
            }
            
            // Añadimos el estudiante a la lista de esa materia
            estudiantesPorFalencia.get(falencia).add(e);
        }
    }

    public void configurarProfesores(List<Profesor> profesores) {
        for (Profesor p : profesores) {
            // usamos la especialidad como clave
            asignacionProfesor.put(p.getEspecialidad(), p);
        }
    }

    public String grafoComoTexto(String materiaBuscada) {
        StringBuilder sb = new StringBuilder();

        if (!estudiantesPorFalencia.containsKey(materiaBuscada)) {
            sb.append("\n--------------------------------------------------\n");
            sb.append(" ERROR: No existen estudiantes con falencia en ")
              .append(materiaBuscada.toUpperCase())
              .append(".\n");
            sb.append(" grafo no encontrado\n");
            sb.append("--------------------------------------------------\n");
            return sb.toString();
        }

        // 2. Obtener los Nodos y Aristas del Grafo
        List<Estudiante> grupoEstudiantes = estudiantesPorFalencia.get(materiaBuscada);
        Profesor profesorAsignado = asignacionProfesor.get(materiaBuscada);

        sb.append("\n==================================================\n");
        sb.append("    GRAFO DE ASIGNACIÓN PARA: ")
          .append(materiaBuscada.toUpperCase())
          .append("\n");
        sb.append("==================================================\n");

        // --- CONEXIÓN 1: MATERIA -> PROFESOR ---
        sb.append("  TUTOR ASIGNADO: ");
        if (profesorAsignado != null) {
            sb.append(profesorAsignado.getNombre())
              .append(" (")
              .append(profesorAsignado.getEspecialidad())
              .append(")\n");
        } else {
            sb.append("ERROR: No hay profesor especialista en ")
              .append(materiaBuscada)
              .append(".\n");
        }

        // --- CONEXIÓN 2: ESTUDIANTES -> MATERIA ---
        sb.append("\n  ESTUDIANTES ASIGNADOS (")
          .append(grupoEstudiantes.size())
          .append(" en total):\n");
        sb.append("  --------------------------------------------------\n");

        for (Estudiante e : grupoEstudiantes) {
            int nota = e.getNota(materiaBuscada);

            sb.append("  > Estudiante: ")
              .append(e.getNombre()).append(" ")
              .append(e.getApellido())
              .append(" (Usuario: ")
             // .append(e.getUsuario())
              .append(")\n");

            sb.append("    - Nota en ")
              .append(materiaBuscada)
              .append(": ")
              .append(nota)
              .append("\n");
        }

        sb.append("  --------------------------------------------------\n");

        return sb.toString();
    }

//    public void mostrarGrafoPorMateria(String materiaBuscada) {
//        String texto = grafoComoTexto(materiaBuscada);
//        System.out.println(texto);
//    } 
    
    public Profesor obtenerTutorPorMateria(String materiaBuscada) {
    return asignacionProfesor.get(materiaBuscada);
}

 
}