package ir.emadi.amir;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        welcomeMessage();
        // '1' -> Iran, '2' -> USA and 'null' -> Unknown
        String typeSystem = null;
        var scanner = new Scanner(System.in);
        while (true) {
            try {
                if (typeSystem == null) {
                    System.out.print("Enter your grading system, please -> 1.Iran or 2.USA: ");
                    typeSystem = scanner.nextLine();
                    if (!(typeSystem.equals("1") || typeSystem.equals("2"))) {
                        typeSystem = null;
                        throw new Exception("Enter 1 or 2, please!");
                    }
                }
                System.out.println();
                break;
            } catch(Exception e) {
                System.out.println("Error -> " + e.getMessage());
                System.out.println("-".repeat(44));
            }
        }
    }

    private static void welcomeMessage() {
        var message = "* Welcome to the Student Grade Calculator! *";
        System.out.println("*".repeat(message.length()));
        System.out.println(message);
        System.out.println("*".repeat(message.length()) + "\n");
    }

}
