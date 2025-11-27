
package Estructuras_De_Datos;

import java.util.*;
import Poo.Estudiante;
import Poo.Profesor;

public class GrafoTutoria {
    
    private Map<String,List<Estudiante>> estudiantesPorFalencia; // recibe una materia en ell String y luego busca la lista de estudiantes con esa falencia 
    
    
    //String recibe el nombre de la materia 
    //List<Estudiante> retorna lo que esta almacenado en al lista con ese nombre
    //es decir si el string fuera matematicas reotrnaria todos los estudiantes con falencias en matematicas
    
    private Map<String,Profesor> asignacionProfesor;//lo que hace es recibe una materia y luego busca el profe para esa materia
    
    // Key: Falencia (Materia) // la arista de mi grafo 
    // Value: Profesor asignado a esa materia
    
    public GrafoTutoria(){
        this.asignacionProfesor= new HashMap<>();
        this.estudiantesPorFalencia = new HashMap <>();
        
        
        
    }
    

    //creo el grafo de estudiantes 
    public void construirGrafo(List<Estudiante> estudiantes) { // todo los datos disponibles para construir el grafo 
        for (Estudiante e : estudiantes) { // recorre la lista 
            String falencia = e.getMateriaBaja(); // debuelbe la materia mas baja del estudiante y la almacena en falencia
            
            // Si la falencia (nodo) no existe, se inicializa su lista
            if (!estudiantesPorFalencia.containsKey(falencia)) {   //containsKey(falencia): Esta función revisa el HashMap (estudiantesPorFalencia) y pregunta: "¿Ya existe una clave con el nombre de esta materia de falencia (falencia / ejemplo: "Matemáticas")?"
                estudiantesPorFalencia.put(falencia, new ArrayList<>()); //Si la condición se cumple (es decir, la materia es nueva en el grafo), el código usa el método put para crear el nodo central.

//Clave: Usa la String de la materia (falencia) como la clave.
//Valor: Asigna una lista de estudiantes vacía (new ArrayList<>()) a esa clave.
            }
            
            // Conecta el estudiante a la falencia (añadir a la lista)
            estudiantesPorFalencia.get(falencia).add(e); // con el get busco la lista de adyacencia y con el add agrego el estudiante a esa lista 
        }
        
        // en este metodo construimos los diferentes grafos por materia el nodo central es la materi donde tiene la falencia la persona
    }

    /**
     * Muestra la estructura final del grafo y las asignaciones de tutoría.
     */
    public void mostrarGrafoPorMateria(String materiaBuscada) {
    // 1. Validar que la materia exista como falencia grupal
    //Es crucial preguntar al mapa de estudiantes: ¿Existe un nodo central para esta materiaBuscada?
//Si no existe (!containsKey), significa que ningún estudiante tiene esa materia como falencia, por lo tanto, no hay grafo que mostrar. Se emite un error y se termina el método (return).
    if(!estudiantesPorFalencia.containsKey(materiaBuscada)){
        System.out.println("\n--------------------------------------------------");
        System.out.println(" ERROR: No existen estudiantes con falencia en " + materiaBuscada.toUpperCase() + ".");
        System.out.println("grafo no encontrado");
        System.out.println("--------------------------------------------------");
        return; // Termina la ejecución si no hay datos
    }
    
    // 2. Obtener los Nodos y Aristas del Grafo
    
    // a) Nodos Secundarios (Estudiantes) - La Lista de Aristas N:1
    List<Estudiante> grupoEstudiantes = estudiantesPorFalencia.get(materiaBuscada); // buscamos la lista que corresponde a la materia que queremos 
    
    
    // b) Nodo Asignado (Profesor) - La Arista 1:1
    Profesor profesorAsignado = asignacionProfesor.get(materiaBuscada);// busco al profe que digta esta materia
    
    System.out.println("\n==================================================");
    System.out.println("    GRAFO DE ASIGNACIÓN PARA: " + materiaBuscada.toUpperCase()); // .toUpperCase me pone las letras en mayucula 
    System.out.println("==================================================");
    
    // --- CONEXIÓN 1: NODO MATERIA -> NODO PROFESOR (1:1) ---
    System.out.print("  TUTOR ASIGNADO: ");
    if (profesorAsignado != null) {
        System.out.println(profesorAsignado.getNombre() + " (" + profesorAsignado.getEspecialidad() + ")");
    } else {
        System.out.println("️ ERROR: No hay profesor especialista en " + materiaBuscada + ".");
    }
    
    // --- CONEXIÓN 2: NODO ESTUDIANTES -> NODO MATERIA (N:1) ---
    System.out.println("\n  ESTUDIANTES ASIGNADOS (" + grupoEstudiantes.size() + " en total):");
    System.out.println("  --------------------------------------------------");

    for (Estudiante e : grupoEstudiantes) {
        // Obtenemos la nota del estudiante en la materia específica
        int nota = e.getNota(materiaBuscada); 

        // Imprimimos la conexión (Arista)
        System.out.printf("  > Estudiante: %s %s (Usuario: %s) \n", 
            e.getNombre(), 
            e.getApellido(), 
            e.getUsuario() 
        );
        System.out.printf("    - Nota en %s: %d\n", materiaBuscada, nota);
    }
    System.out.println("  --------------------------------------------------");

    
    
}
    

    public void configurarProfesores(List<Profesor> profesores) {
        // Itera sobre la lista de profesores que le pasamos desde el main
        for (Profesor p : profesores) {
            // Usa la especialidad del profesor (ej. "Lenguaje") como clave
            // y el objeto Profesor (ej. Profe. Laura) como valor.
            asignacionProfesor.put(p.getEspecialidad(), p); // guarda en el hasmap un profesor con una materia
        }//es decir por cada materia existe un profesor osea por cada ameria hay un grafo con un elemento
    }
    
}

//osea como defini el hasmap profes lo unico que hace es recibir lac lave y objectos profes y los guarda enconbio el estudiantes recibe listas y pues tenog que inicializarlas y asi poder guardar info depsues