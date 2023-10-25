package ru.mirea.task11;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calendar currentDateTime = new GregorianCalendar();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        System.out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt() - 1;
        System.out.print("Введите день: ");
        int day = scanner.nextInt();
        System.out.print("Введите час (0-23): ");
        int hour = scanner.nextInt();
        System.out.print("Введите минуты (0-59): ");
        int minute = scanner.nextInt();

        Calendar userDateTime = new GregorianCalendar(year, month, day, hour, minute);

        if (userDateTime.compareTo(currentDateTime) > 0) {
            System.out.println("Введенная дата и время позже текущего времени.");
        } else if (userDateTime.compareTo(currentDateTime) < 0) {
            System.out.println("Введенная дата и время раньше текущего времени.");
        } else {
            System.out.println("Введенная дата и время совпадают с текущим временем.");
        }
    }
}
