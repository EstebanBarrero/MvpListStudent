package views;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }
    //No sirven los metodos de Scanner en View
    public void closeScanner(){
        scanner.close();
    }
}
