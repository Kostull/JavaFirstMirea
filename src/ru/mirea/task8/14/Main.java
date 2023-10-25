package ru.mirea.task8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число N: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n <= 0) {
            System.out.println("Введите натуральное число.");
            return;
        }

        String numberAsString = String.valueOf(n);

        for (int i = 0; i < numberAsString.length(); i++) {
            System.out.println(numberAsString.charAt(i));
        }
    }
}
