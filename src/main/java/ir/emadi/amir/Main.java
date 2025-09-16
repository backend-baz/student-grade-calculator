package ir.emadi.amir;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String... args) {
        welcomeMessage();
        // '1' -> Iran, '2' -> USA and 'null' -> Unknown
        String typeSystem = null;
        var grades = new ArrayList<HashMap<String, Double>>();
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
                System.out.print("Enter its credit, please: ");
                var credit = Double.parseDouble(scanner.nextLine());
                if (credit <= 0 || credit > 10)
                    throw new Exception("Enter a number between 0 to 10, please! (excluded 0)");
                System.out.print("Continue? y/n: ");
                var userContinue = scanner.nextLine();
                if (userContinue.equalsIgnoreCase("y")) {
                    var dic = new HashMap<String, Double>();
                    dic.put("grade", grade);
                    dic.put("credit", credit);
                    grades.add(dic);
                    printLines();
                    continue;
                }
                printLines("=");
                break;
            } catch(NumberFormatException e) {
                System.out.println("Error -> Invalid Input! Try again, please.");
                printLines();
            } catch(Exception e) {
                System.out.println("Error -> " + e.getMessage());
                printLines();
            }
        }
        scanner.close();
    }

    private static void printLines(String character) {
        System.out.print(character.repeat(44));
    }

    private static void printLines() {
        System.out.print("-".repeat(44));
    }

    private static void welcomeMessage() {
        var message = "* Welcome to the Student Grade Calculator! *";
        printLines("*");
        System.out.println();
        System.out.println(message);
        printLines("*");
        System.out.println("\n");
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
