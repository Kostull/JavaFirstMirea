package ru.mirea.task8;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        printOddNumbers();
    }

    public static void printOddNumbers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        System.out.println("Введите последовательность натуральных чисел (введите 0 для завершения ввода):");

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }

        System.out.println("Нечетные числа из последовательности:");
        for (int oddNumber : oddNumbers) {
            System.out.println(oddNumber);
        }
    }
}
