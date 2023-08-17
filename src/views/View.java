package views;

import java.util.Scanner;

public class View {

    public static final String CLOSE = "¡Hasta luego!";
    public static final String OPTION_INVALIDATE = "Opción no válida. Intente nuevamente.";
    public static final String READ_ERR0R = "Error al leer la entrada.";
    public static final String READ_TEXT_CHARACTERS = "^[a-zA-Z\\s]+$";
    public static final String READ_NOT_NULL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
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

    public void menu(){
        System.out.println("=== MENÚ - LISTA ESTUDIANTES PROGRAMACIÓN III ===\n1. Ver estudiantes registrados"
                            + "\n2. Registrar un nuevo estudiante\n3. Modificar registro de estudiante\n4. Eliminar registro de estudiante"
                            + "\n0. Salir");
    }

    public String textCharacterRestriccion(){
        return READ_TEXT_CHARACTERS;
    }

    public String stringNotNull(){
        return READ_NOT_NULL;
    }

    public void numError(){
        System.out.println("Error: Ingrese un número válido.");
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
