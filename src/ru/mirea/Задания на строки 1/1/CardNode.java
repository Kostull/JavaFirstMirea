package ru.mirea.task10;

import java.util.Scanner;

public class CardNode {
    private String name;
    private int age;

    public void readAttributes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = scanner.nextInt();
    }

    public void displayAttributes() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
