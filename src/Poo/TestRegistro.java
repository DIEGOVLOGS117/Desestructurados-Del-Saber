package Poo;

import Poo.Estudiante;
import Poo.Profesor;
import Poo.ValidadorRegistro;

import java.util.List;
import java.util.Scanner;

public class TestRegistro {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de estudiante ===");

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Ingrese nombre de usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese contrasena: ");
        String password = sc.nextLine();

        // Validar datos ingresados
        List<String> errores = ValidadorRegistro.validateRegistration(nombre, apellido, usuario, password);

        if (!errores.isEmpty()) {
            System.out.println("\n Errores en el registro:");
            errores.forEach(System.out::println);
            return;
        }

        // Si pasa validaciones, registrar estudiante
        Estudiante estudiante = new Estudiante(nombre, apellido, usuario, password);

        System.out.print("\nIngrese el puntaje del examen (0-100): ");
        int puntaje = sc.nextInt();
        estudiante.registrarExamen(puntaje);

        System.out.println("\n Registro exitoso");
        System.out.println("Estudiante registrado:");
        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Usuario: " + estudiante.getUsuario());
        System.out.println("Puntaje examen: " + estudiante.getPuntajeExamen());

        sc.close();
    }
}
