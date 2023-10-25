package ru.mirea.task1;

import java.util.Scanner;

public class Main_1_7 {
    public static void main(String[] args) {

        // Задание 3
        System.out.println("Задание 3");
        int[] arr = new int[] {4, 8, 11, 3, 26};
        int sum = 0, med;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        med = sum / arr.length;

        System.out.println("summa: " + sum);
        System.out.println("medium: " + med);

        // Задание 4
        System.out.println("\nЗадание 4");
        int[] mass = new int[6];
        Scanner scan = new Scanner(System.in);

        int i = 0;
        sum = 0;
        do {
            int value = scan.nextInt();
            mass[i] = value;
            sum += mass[i];
            i++;
        } while (i < mass.length);

        i = 0;
        int min = mass[0], max = mass[0];
        while (i < mass.length) {
            if (mass[i] < min) {
                min = mass[i];
            }
            if (mass[i] > max) {
                max = mass[i];
            }
            i++;
        }
        System.out.println("summa: " + sum);
        System.out.println("minimum: " + min);
        System.out.println("maximum: " + max);

        // Задание 5
        System.out.println("\nЗадание 5");
        for(i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        // Задание 6
        System.out.println("\nЗадание 6");
        for (float j = 1.0f; j <= 10; j++) {
            float a = 1 / j;
            System.out.println(String.format("%.6f", a));
        }

        // Задание 7
        System.out.println("\nЗадание 7");
        int s = scan.nextInt();
        System.out.println(fact(s));
    }
    public static int fact(int x) {

        int factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
