package presenters;

import models.Estudiante;
import views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Scanner_Lista_Estudiantes_PIII {

    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static View view;

    public Main_Scanner_Lista_Estudiantes_PIII() {
        view = new View();
    }

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    verEstudiantesRegistrados();                // Agregamos la opción para ver la lista de estudiantes
                    break;
                case 2:
                    registrarEstudiante();                      // Agregamos la opción para registrar un estudiante
                    break;
                case 3:
                    modificarEstudiante();                      // Agregamos la opción para modificar un estudiante
                    break;
                case 4:
                    eliminarEstudiante();                       // Agregamos la opción para eliminar un estudiante
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

         scanner.close();// Cerrar el scanner al finalizar
    }


    private static void mostrarMenu() {                         // mostrar opciones menú
        System.out.println("=== MENÚ - LISTA ESTUDIANTES PROGRAMACIÓN III ===");
        System.out.println("1. Ver estudiantes registrados");
        System.out.println("2. Registrar un nuevo estudiante");
        System.out.println("3. Modificar registro de estudiante");
        System.out.println("4. Eliminar registro de estudiante");
        System.out.println("0. Salir");
    }


    private static int leerOpcion() {                               // método para leer tipo de dato - opción menú
        int opcion;
        while (true) {
            try {
                System.out.print("Ingrese una opción: ");
                String input = scanner.nextLine().trim();         //para leer la entrada del usuario espacios en blanco adicionales y saltos de línea vacíos
                if (!input.isEmpty()) {
                    opcion = Integer.parseInt(input);
                    if (opcion >= 0 && opcion <= 4) {
                        break;
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                } else {
                    System.out.println("No se permiten campos vacíos. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        return opcion;
    }


    private static void verEstudiantesRegistrados() {                       //método para leer lista estudiantes
        if (estudiantes.isEmpty()) {                                        //Verifica si la lista de estudiantes está vacía
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("=== Estudiantes Registrados ===");
            int index = 0;
            for (Estudiante estudiante : estudiantes) {                     //bucle for-each que recorre la lista de estudiantes
                System.out.println("Índice " + index + ": " + estudiante);
                index++;
            }
        }
    }


    private static void registrarEstudiante() {                             //método para registrar estudiantes
        System.out.println("=== Registrar Estudiante ===");

        System.out.print("Nombres y Apellidos: ");
        String nombresApellidos = leerCadenaNoVaciaTexto();                 //valida tipo dato (solo texto)y entrada no vacía

        System.out.print("Código de Estudiante: ");
        String codigoEstudiante = leerCadenaNoVacia();                      //valida entrada no vacía

        System.out.print("Correo Electrónico: ");
        String correoElectronico = leerCadenaNoVaciaCorreo();               //valida tipo dato (tipo correo xxx@.xxx)y entrada no vacía

        estudiantes.add(new Estudiante(nombresApellidos, codigoEstudiante, correoElectronico)); // agrega un nuevo objeto Estudiante a la lista de estudiantes estudiantes
        System.out.println("Estudiante registrado exitosamente.");
    }


    private static void modificarEstudiante() {                                        //método para modificar estudiantes registrados en la lista
        System.out.println("=== Modificar Registro de Estudiante ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        verEstudiantesRegistrados();
        System.out.print("Ingrese el índice del estudiante que desea modificar: ");
        int indice = leerIndiceValido(estudiantes.size());

        Estudiante estudianteSeleccionado = estudiantes.get(indice);            //obtiene el estudiante de la lista estudiantes que corresponde al índice especificado y lo almacena en la variable estudianteSeleccionado

        System.out.print("Nuevo Nombres y Apellidos: ");
        String nuevosNombresApellidos = leerCadenaNoVaciaTexto();

        System.out.print("Nuevo Código de Estudiante: ");
        String nuevoCodigoEstudiante = leerCadenaNoVacia();

        System.out.print("Nuevo Correo Electrónico: ");
        String nuevoCorreoElectronico = leerCadenaNoVaciaCorreo();

        estudianteSeleccionado.nombresApellidos = nuevosNombresApellidos;
        estudianteSeleccionado.codigoEstudiante = nuevoCodigoEstudiante;
        estudianteSeleccionado.correoElectronico = nuevoCorreoElectronico;

        System.out.println("Estudiante modificado exitosamente.");
    }


    private static void eliminarEstudiante() {                                      //método para eliminar estudiantes registrados de la lista estudiantes
        System.out.println("=== Eliminar Registro de Estudiante ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        verEstudiantesRegistrados();

        System.out.print("Ingrese el índice del estudiante que desea eliminar: ");
        int indice = leerIndiceValido(estudiantes.size());

        estudiantes.remove(indice);

        System.out.println("Estudiante eliminado exitosamente.");
    }

    private static int leerIndiceValido(int maximo) {   //método complementario a verEstudiantesRegistrados()y otros métodos para validar entrada del índice entre >=0 y (maximo)
        int indice;
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                indice = Integer.parseInt(input);
                if (indice >= 0 && indice < maximo) {
                    break;
                }
                System.out.println("Índice no válido. Intente nuevamente.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        return indice;
    }

    private static String leerCadenaNoVaciaCorreo() {       // método para validar tipo dato (tipo correo xxx@.xxx)y entrada no vacía
        String input;
        while (true) {
            try {
                input = scanner.nextLine().trim();
                if (!input.isEmpty() && input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")) {
                    return input;
                }
                System.out.println("Ingrese una dirección de correo válida. Intente nuevamente.");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

    private static String leerCadenaNoVacia() {              //método para validar entrada no vacía y registrar la identificación
        String input;
        while (true) {
            try {
                input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                }
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

    private static String leerCadenaNoVaciaTexto() {        //método para validar entrada tipo texto
        String input;
        while (true) {
            try {
                input = scanner.nextLine().trim();
                if (!input.isEmpty() && input.matches("^[a-zA-Z\\s]+$")) {  //método matches para verificar si la cadena input coincide con la expresión regular "^[a-zA-Z\\s]+$"
                    return input;
                }
                System.out.println("Ingrese un valor válido (solo texto). Intente nuevamente.");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }


}
