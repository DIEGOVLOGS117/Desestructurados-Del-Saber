package Poo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TestRegistro {

    // Metodo auxiliar para pedir un dato con validacion y hasta 3 intentos
    private static String pedirDato(Scanner sc, String mensaje, Pattern patron, String errorMsg) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();

            if (!entrada.isEmpty() && patron.matcher(entrada).matches()) {
                return entrada; // valido → lo devuelve
            }

            intentos++;
            System.out.println("ERROR " + errorMsg + " (Intento " + intentos + " de 3)");
        }

        System.out.println("\n Demasiados intentos fallidos. El registro se cancelo.");
        System.exit(0);
        return null; // nunca llega aquí, pero el compilador lo exige
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de estudiante ===");

        // Expresiones regulares
        Pattern soloLetras = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$");
        Pattern usuarioValido = Pattern.compile("^[a-zA-Z0-9]+$");
        Pattern contrasenaValida = Pattern.compile("^[a-zA-Z0-9]+$");

        // Solicitar datos con validación
        String nombre = pedirDato(sc, "Ingrese nombre: ", soloLetras,
                "El nombre debe contener solo letras y no puede estar vacio.");
        String apellido = pedirDato(sc, "Ingrese apellido: ", soloLetras,
                "El apellido debe contener solo letras y no puede estar vacio.");
        String usuario = pedirDato(sc, "Ingrese nombre de usuario: ", usuarioValido,
                "El usuario solo puede contener letras y numeros (sin espacios ni simbolos).");
        String password = pedirDato(sc, "Ingrese contrasena: ", contrasenaValida,
                "La contrasena solo puede contener letras y numeros (sin simbolos).");

        // Crear estudiante
        Estudiante estudiante = new Estudiante(nombre, apellido, usuario, password);

        // PUNTAJE DEL EXAMEN (máximo 3 intentos)
        int intentos = 0;
        int puntaje = -1;
        while (intentos < 3) {
            System.out.print("\nIngrese el puntaje del examen (0-100): ");

            if (sc.hasNextInt()) {
                puntaje = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if (puntaje >= 0 && puntaje <= 100) {
                    break; // válido
                }
            } else {
                sc.nextLine(); // limpiar entrada no numérica
            }

            intentos++;
            System.out.println("ERROR Puntaje invalido. Debe ser un numero entre 0 y 100. (Intento " + intentos + " de 3)");
        }

        if (intentos == 3) {
            System.out.println("\nDemasiados intentos fallidos. El registro se cancelo.");
            System.exit(0);
        }

        estudiante.registrarExamen(puntaje);

        // Registro exitoso
        System.out.println("\n Registro exitoso");
        System.out.println("Estudiante registrado:");
        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Usuario: " + estudiante.getUsuario());
        System.out.println("Puntaje examen: " + estudiante.getPuntajeExamen());

        sc.close();
    }
}
