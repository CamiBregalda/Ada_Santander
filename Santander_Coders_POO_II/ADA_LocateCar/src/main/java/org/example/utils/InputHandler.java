package org.example.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputHandler {
    public static int getIntInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int input = scanner.nextInt();

        return input;
    }

    public static String getStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = scanner.nextLine();

        return input;
    }

    public static double getDoubleInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        double input = scanner.nextDouble();

        return input;
    }

    public static LocalDate getLocalDateInput(String message) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;

        while (date == null) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                date = LocalDate.parse(input, dateFormatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
            }
        }

        return date;
    }

    public static LocalTime getLocalTimeInput(String message) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = null;

        while (time == null) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                time = LocalTime.parse(input, timeFormatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Formato de hora inválido. Use o formato HH:mm.");
            }
        }

        return time;
    }
}
