package presenters;

import models.Estudiante;
import views.View;

import java.util.ArrayList;
import java.util.List;

public class Presenter {

    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static View view = new View();

    public void startMenu(){
        int opcion;
        do {
            view.showMenu();
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
                    view.closeMenu();
                    break;
                default:
                    view.optionInvalidate();
            }
        } while (opcion != 0);
        view.closeScanner();// Cerrar el scanner al finalizar
    }

    private static int leerOpcion() {                               // método para leer tipo de dato - opción menú
        int opcion;
        while (true) {
            try {
                view.enterOption();
                String input = view.openScannerNextLineTrim();         //para leer la entrada del usuario espacios en blanco adicionales y saltos de línea vacíos
                if (!input.isEmpty()) {
                    opcion = Integer.parseInt(input);
                    if (opcion >= 0 && opcion <= 4) {
                        break;
                    } else {
                        view.optionInvalidate();
                    }
                } else {
                    view.showNotNull();
                }
            } catch (NumberFormatException e) {
                view.numError();
            }
        }
        return opcion;
    }


    private static void verEstudiantesRegistrados() {                       //método para leer lista estudiantes
        if (estudiantes.isEmpty()) {                                        //Verifica si la lista de estudiantes está vacía
            view.showNullResgisterStudents();
        } else {
            view.showRegisterStudents();
            int index = 0;
            for (Estudiante estudiante : estudiantes) {                     //bucle for-each que recorre la lista de estudiantes
                System.out.println("Índice " + index + ": " + estudiante);
                index++;
            }
        }
    }


    private static void registrarEstudiante() {                             //método para registrar estudiantes
        view.showRegisterStudents();

        view.showNameStudent();
        String nombresApellidos = leerCadenaNoVaciaTexto();                 //valida tipo dato (solo texto)y entrada no vacía

        view.studentCode();
        String codigoEstudiante = leerCadenaNoVacia();                      //valida entrada no vacía

        view.studentEmail();
        String correoElectronico = leerCadenaNoVaciaCorreo();               //valida tipo dato (tipo correo xxx@.xxx)y entrada no vacía

        estudiantes.add(new Estudiante(nombresApellidos, codigoEstudiante, correoElectronico)); // agrega un nuevo objeto Estudiante a la lista de estudiantes estudiantes
        view.registeredStudent();
        view.showRegisterStudents();
    }


    private static void modificarEstudiante() {                                        //método para modificar estudiantes registrados en la lista
        view.showMenuModifiedStudent();
        if (estudiantes.isEmpty()) {
            view.showNullResgisterStudents();
            return;
        }
        verEstudiantesRegistrados();
        view.showIndexModiedStudent();
        int indice = leerIndiceValido(estudiantes.size());

        Estudiante estudianteSeleccionado = estudiantes.get(indice);            //obtiene el estudiante de la lista estudiantes que corresponde al índice especificado y lo almacena en la variable estudianteSeleccionado

        view.showNameStudent();
        String nuevosNombresApellidos = leerCadenaNoVaciaTexto();

        view.showIdStudent();
        String nuevoCodigoEstudiante = leerCadenaNoVacia();

        view.showEmailStudent();
        String nuevoCorreoElectronico = leerCadenaNoVaciaCorreo();

        estudianteSeleccionado.nombresApellidos = nuevosNombresApellidos;
        estudianteSeleccionado.codigoEstudiante = nuevoCodigoEstudiante;
        estudianteSeleccionado.correoElectronico = nuevoCorreoElectronico;

        view.showModifiedStudent();
    }


    private static void eliminarEstudiante() {                                      //método para eliminar estudiantes registrados de la lista estudiantes
        view.showMenuDeleteStudent();
        if (estudiantes.isEmpty()) {
            view.showNullResgisterStudents();
            return;
        }

        verEstudiantesRegistrados();


        int indice = leerIndiceValido(estudiantes.size());

        estudiantes.remove(indice);

        view.showDeleteStudent();
    }

    private static int leerIndiceValido(int maximo) {   //método complementario a verEstudiantesRegistrados()y otros métodos para validar entrada del índice entre >=0 y (maximo)
        int indice;
        while (true) {
            try {
                String input = view.openScannerNextLineTrim();
                indice = Integer.parseInt(input);
                if (indice >= 0 && indice < maximo) {
                    break;
                }
                view.invalidateIndex();
            } catch (NumberFormatException e) {
                view.numError();
            }
        }
        return indice;
    }

    private static String leerCadenaNoVaciaCorreo() {       // método para validar tipo dato (tipo correo xxx@.xxx)y entrada no vacía
        String input;
        while (true) {
            try {
                input = view.openScannerNextLineTrim();
                if (!input.isEmpty() && input.matches(view.stringNotNull())) {
                    return input;
                }
                view.invalidateEmail();
            } catch (java.util.InputMismatchException e) {
                view.readError();
            }
        }
    }

    private static String leerCadenaNoVacia() {              //método para validar entrada no vacía y registrar la identificación
        String input;
        while (true) {
            try {
                input = view.openScannerNextLineTrim();
                if (!input.isEmpty()) {
                    return input;
                }
                view.showNotNull();
            } catch (java.util.InputMismatchException e) {
                view.readError();
            }
        }
    }

    private static String leerCadenaNoVaciaTexto() {        //método para validar entrada tipo texto
        String input;
        while (true) {
            try {
                input = view.openScannerNextLineTrim();
                if (!input.isEmpty() && input.matches(view.textCharacterRestriccion())) {  //método matches para verificar si la cadena input coincide con la expresión regular "^[a-zA-Z\\s]+$"
                    return input;
                }
                view.showValueTxt();
            } catch (java.util.InputMismatchException e) {
                view.readError();
            }
        }
    }
}