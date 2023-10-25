package ru.mirea.task8;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        readAndPrintOddPositions();
    }

    public static void readAndPrintOddPositions() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        int count = 1;

        System.out.println("Введите последовательность натуральных чисел (введите 0 для завершения ввода):");

        while (true) {
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (count % 2 != 0) {
                oddNumbers.add(number);
            }
            count++;
        }

        System.out.println("Числа с нечётным номером:");
        for (int oddNumber : oddNumbers) {
            System.out.println(oddNumber);
        }
    }
}
