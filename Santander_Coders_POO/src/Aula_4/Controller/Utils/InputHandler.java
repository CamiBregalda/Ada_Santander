import java.util.Scanner;
public class InputHandler {

    public static int getIntInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int input = scanner.nextInt();

        return input;
    }

    public static String getStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();

        return input;
    }
}