package utils;

import java.util.Scanner;

public class Consola {
     private static final Scanner SCANNER = new Scanner(System.in);  
 
    public static void pause() {
        System.out.println("Presiona Enter para continuar...");
        SCANNER.nextLine(); 
    }

    public static void cleanScreen() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
            } catch (Exception e) {
                System.out.println("Error al limpiar la pantalla: " + e.getMessage());
            }
        } else {
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
        }
    }

    public static int optionValidation(String statement, int lower, int upper) {
        while (true) {
            try {
                System.out.println(statement); 
                int option = SCANNER.nextInt();  
                SCANNER.nextLine();  
                if (option >= lower && option <= upper) {
                    return option; 
                } else {
                    System.out.printf("Elige un número entre %d y %d.%n", lower, upper); 
                }
            } catch (Exception e) {
                System.out.println("Introduce un número válido.");  
                SCANNER.nextLine();  
            }
        }
    }
}
