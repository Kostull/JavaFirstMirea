package ru.mirea.task18;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                String key = myScanner.next();
                printDetails(key);
                validInput = true; // Если выполнено успешно, выходим из цикла
            } catch (Exception e) {
                // Обработка исключения
                System.out.println("Caught Exception: " + e.getMessage());
                System.out.println("Please enter a valid key.");
                myScanner.nextLine(); // Очистка буфера ввода
            }
        } while (!validInput);
    }

    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            // Обработка исключения
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to an empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.getKey();
    }
}
