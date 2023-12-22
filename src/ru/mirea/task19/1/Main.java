package ru.mirea.task19;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваши ФИО:");
        String fullName = scanner.nextLine();

        System.out.println("Введите ваш ИНН:");
        String inn = scanner.nextLine();

        try {
            if (isValidINN(inn)) {
                System.out.println("Введен верный ИНН. Заказ оформлен.");
            } else {
                System.out.println("Введен неверный ИНН. Заказ не оформлен.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }
    }

    private static boolean isValidINN(String inn) {
        if (inn == null || inn.length() != 12) {
            throw new IllegalArgumentException("ИНН должен содержать 12 цифр");
        }

        int[] coefficientsForCheck = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int sum = 0;

        for (int i = 0; i < coefficientsForCheck.length; i++) {
            sum += Integer.parseInt(String.valueOf(inn.charAt(i))) * coefficientsForCheck[i];
        }

        int controlDigit = sum % 11 % 10;
        int lastDigit = Integer.parseInt(String.valueOf(inn.charAt(11)));

        return controlDigit == lastDigit;
    }
}
