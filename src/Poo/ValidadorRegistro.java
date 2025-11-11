package Poo;

import java.util.ArrayList;
import java.util.List;

public class ValidadorRegistro {

    public static boolean isEmptyOrBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean hasSpace(String s) {
        return s.contains(" ");
    }

    public static boolean isLettersOnly(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }

    public static boolean isAlphanumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }

    public static List<String> validateRegistration(String nombre, String apellido, String usuario, String password) {
        List<String> errors = new ArrayList<>();

        // Nombre
        if (isEmptyOrBlank(nombre)) {
            errors.add("El nombre es obligatorio.");
        } else if (hasSpace(nombre)) {
            errors.add("El nombre no puede tener espacios.");
        } else if (!isLettersOnly(nombre)) {
            errors.add("El nombre solo puede contener letras.");
        }

        // Apellido
        if (isEmptyOrBlank(apellido)) {
            errors.add("El apellido es obligatorio.");
        } else if (hasSpace(apellido)) {
            errors.add("El apellido no puede tener espacios.");
        } else if (!isLettersOnly(apellido)) {
            errors.add("El apellido solo puede contener letras.");
        }

        // Usuario
        if (isEmptyOrBlank(usuario)) {
            errors.add("El usuario es obligatorio.");
        } else if (hasSpace(usuario)) {
            errors.add("El usuario no puede tener espacios.");
        } else if (!isLettersOnly(usuario)) {
            errors.add("El usuario solo puede contener letras.");
        }

        // Contraseña
        if (isEmptyOrBlank(password)) {
            errors.add("La contrasena es obligatoria.");
        } else if (hasSpace(password)) {
            errors.add("La contrasena no puede tener espacios.");
        } else if (password.length() < 6) {
            errors.add("La contrasena debe tener mínimo 6 caracteres.");
        } else if (!isAlphanumeric(password)) {
            errors.add("La contrasena solo puede tener letras y números.");
        }

        return errors;
    }
}
