package ru.mirea.task14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d\\+");

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("В тексте есть цифра, после которой стоит знак '+'");
        } else {
            System.out.println("В тексте нет цифры, после которой стоит знак '+'");
        }
    }
}
