package Poo;

import Poo.Estudiante;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TestRegistro {


     // Detecta si el texto contiene números o símbolos
    private static boolean contieneCaracteresInvalidos(String texto) {
        return !texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$");
    }

    // No permitir más de 2 letras iguales consecutivas
    private static boolean tieneRepeticionesExcesivas(String texto) {
        String t = texto.toLowerCase();
        for (int i = 0; i < t.length() - 2; i++) {
            if (t.charAt(i) == t.charAt(i + 1) && t.charAt(i + 1) == t.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    // Detecta patrones repetidos como "anaana" o "ioioio"
    private static boolean tienePatronRepetido(String texto) {
        String t = texto.toLowerCase();
        int len = t.length();

        for (int size = 1; size <= len / 2; size++) {
            String patron = t.substring(0, size);

            StringBuilder sb = new StringBuilder();
            while (sb.length() < len) {
                sb.append(patron);
            }

            String generado = sb.toString().substring(0, len);
            if (generado.equals(t)) {
                return true;
            }
        }
        return false;
    }

    // Valida nombres y apellidos con todas las reglas
    private static boolean nombreInvalido(String texto) {
        if (texto.isEmpty()) return true;
        if (contieneCaracteresInvalidos(texto)) return true;
        if (tieneRepeticionesExcesivas(texto)) return true;
        if (tienePatronRepetido(texto)) return true;
        return false;
    }
    private static String pedirDato(Scanner sc, String mensaje, boolean validarNombreComplejo, Pattern patronSimple, String errorMsg) {
        int intentos = 0;

        while (intentos < 3) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();

            // Validación básica si es usuario/contraseña
            if (!validarNombreComplejo) {
                if (!entrada.isEmpty() && patronSimple.matcher(entrada).matches()) {
                    return entrada;
                }
            }
            // Validación compleja para nombre/apellido
            else {
                if (!nombreInvalido(entrada)) {
                    return entrada;
                }
            }

            intentos++;
            System.out.println("ERROR " + errorMsg + " (Intento " + intentos + " de 3)");
        }

        System.out.println("\n Demasiados intentos fallidos. El registro se cancelo.");
        System.exit(0);
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de estudiante ===");

        Pattern usuarioValido = Pattern.compile("^[a-zA-Z0-9]+$");
        Pattern contrasenaValida = Pattern.compile("^[a-zA-Z0-9]+$");

        // NOMBRE Y APELLIDO (validación avanzada)
        String nombre = pedirDato(sc,
                "Ingrese nombre: ",
                true, null,
                "El nombre no es valido (solo letras, sin simbolos, sin repeticiones exageradas).");

        String apellido = pedirDato(sc,
                "Ingrese apellido: ",
                true, null,
                "El apellido no es valido (solo letras, sin simbolos, sin repeticiones exageradas).");

        // USUARIO Y CONTRASEÑA 
        String usuario = pedirDato(sc,
                "Ingrese nombre de usuario: ",
                false, usuarioValido,
                "El usuario solo puede contener letras y numeros.");

        String password = pedirDato(sc,
                "Ingrese contrasena: ",
                false, contrasenaValida,
                "La contraseña solo puede contener letras y numeros.");

        // CREAR ESTUDIANTE
        Estudiante estudiante = new Estudiante(nombre, apellido, usuario, password);


        // PUNTAJE DEL EXAMEN (con 3 intentos)
        int intentos = 0;
        int puntaje = -1;

        while (intentos < 3) {
    System.out.print("\nIngrese el puntaje del examen (0-100): ");
    String entrada = sc.nextLine().trim();

    // Verifica si está vacío
    if (entrada.isEmpty()) {
        intentos++;
        System.out.println("ERROR El puntaje no puede estar vacio. (Intento " + intentos + " de 3)");
        continue;
    }

    // Verifica si es número válido
    try {
        puntaje = Integer.parseInt(entrada);

        if (puntaje >= 0 && puntaje <= 100) {
            break; // válido
        } else {
            intentos++;
            System.out.println("ERROR Puntaje invalido. Debe estar entre 0 y 100. (Intento " + intentos + " de 3)");
        }

    } catch (NumberFormatException e) {
        intentos++;
        System.out.println("ERROR Debe ingresar un número entero. (Intento " + intentos + " de 3)");
    }
    }

    if (intentos == 3) {
        System.out.println("\nDemasiados intentos fallidos. El registro se cancelo.");
        System.exit(0);
    }

        estudiante.registrarExamen(puntaje);

        
        System.out.println("\n Registro exitoso");
        System.out.println("Estudiante registrado:");
        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Usuario: " + estudiante.getUsuario());
        System.out.println("Puntaje examen: " + estudiante.getPuntajeExamen());

        sc.close();
    }
}
