package ir.emadi.amir;

import java.util.Scanner;
import java.util.regex.Pattern;

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
                System.out.print("Enter your grade, please: ");
                var userGrade = scanner.nextLine();
                double grade;
                if (typeSystem.equals("1")) {
                    grade = Double.parseDouble(userGrade);
                    if (grade < 0 || grade > 20)
                        throw new Exception("Enter a number between 0 to 20, please!");
                } else {
                    if (!isValidAmericanGrade(userGrade))
                        throw new Exception("Enter a letter between 'A' to 'D' or 'F', please! (includes '+' or '-')");
                    grade = convertLetterToGPA(userGrade);
                }
                break;
//                System.out.println("-".repeat(44));
            } catch(NumberFormatException e) {
                System.out.println("Error -> Invalid Input! Try again, please.");
                System.out.println("-".repeat(44));
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

    private static boolean isValidAmericanGrade(String grade) {
        return Pattern.compile("^(?=[abcdfABCDF])[abcdfABCDF\\-+]{1,2}$").matcher(grade).find();
    }

    private static double convertLetterToGPA(String letter) {
        return switch (letter.toUpperCase()) {
            case "A+" -> 4.3;
            case "A" -> 4;
            case "A-" -> 3.7;
            case "B+" -> 3.3;
            case "B" -> 3;
            case "B-" -> 2.7;
            case "C+" -> 2.3;
            case "C" -> 2;
            case "C-" -> 1.7;
            case "D+" -> 1.3;
            case "D" -> 1;
            case "D-" -> 0.7;
            default -> 0; // F
        };
    }

}
