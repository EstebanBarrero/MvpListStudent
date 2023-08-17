package views;

import java.util.Scanner;

public class View {

    public static final String CLOSE = "¡Hasta luego!";
    public static final String OPTION_INVALIDATE = "Opción no válida. Intente nuevamente.";
    public static final String READ_ERR0R = "Error al leer la entrada.";
    public static final String READ_TEXT_CHARACTERS = "^[a-zA-Z\\s]+$";
    public static final String READ_NOT_NULL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    public static final String MAIN_MENU = "=== MENÚ - LISTA ESTUDIANTES PROGRAMACIÓN III ===\n1. Ver estudiantes registrados"
            + "\n2. Registrar un nuevo estudiante\n3. Modificar registro de estudiante\n4. Eliminar registro de estudiante"
            + "\n0. Salir";
    public static final String ERROR_NUM = "Error: Ingrese un número válido.";
    public static final String ENTER_OPTION = "Ingrese una opción: ";
    public static final String REGISTER_STUDENTS = "=== Estudiantes Registrados ===";
    public static final String NOT_NULL = "No se permiten campos vacíos. Intente nuevamente.";
    public static final String VALUE_TXT = "Ingrese un valor válido (solo texto). Intente nuevamente.";
    public static final String NULL_REGISTER_STUDENTS = "No hay estudiantes registrados.";
    public static final String REGISTER_STUDENTS_OK = "Estudiante registrado exitosamente.";
    public static final String EMAIL_STUDENTS = "Correo Electrónico: ";
    public static final String CODE_STUDENTS = "Código de Estudiante: ";
    public static final String NAMES_STUDENTS = "Nombres y Apellidos: ";
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public String openScannerNextLineTrim(){
        return scanner.nextLine().trim();
    }
    public void closeScanner(){
        scanner.close();
    }

    public void showMenu(){
        System.out.println(MAIN_MENU);
    }

    public void nameStudent(){
        System.out.print(NAMES_STUDENTS);
    }
    public void studentCode(){
        System.out.print(CODE_STUDENTS);
    }
    public void studentEmail(){
        System.out.print(EMAIL_STUDENTS);
    }

    public void registeredStudent(){
        System.out.println(View.REGISTER_STUDENTS_OK);
    }


    public void showRegisterStudents(){
        System.out.println(REGISTER_STUDENTS_OK);
    }

    public String textCharacterRestriccion(){
        return READ_TEXT_CHARACTERS;
    }

    public void nullResgisterStudents(){
        System.out.println(NULL_REGISTER_STUDENTS);
    }

    public void enterOption(){
        System.out.print(ENTER_OPTION);
    }

    public String stringNotNull(){
        return READ_NOT_NULL;
    }

    public void showValueTxt(){
        System.out.println(VALUE_TXT);
    }

    public void showNotNull(){
        System.out.println(NOT_NULL);
    }

    public void numError(){
        System.out.println(ERROR_NUM);
    }

    public void readError(){
        System.out.println(READ_ERR0R);
    }

    public void optionInvalidate(){
        System.out.println(OPTION_INVALIDATE);
    }

    public void closeMenu(){
        System.out.println(CLOSE);
    }
}
