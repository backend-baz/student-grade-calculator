package ir.emadi.amir;

public class Main {

    public static void main(String... args) {
        welcomeMessage();
    }

    private static void welcomeMessage() {
        var message = "* Welcome to the Student Grade Calculator! *";
        System.out.println("*".repeat(message.length()));
        System.out.println(message);
        System.out.println("*".repeat(message.length()) + "\n");
    }

}
