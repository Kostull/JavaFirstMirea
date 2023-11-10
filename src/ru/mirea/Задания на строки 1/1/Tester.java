package ru.mirea.task10;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        List1 list = new List1();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add card");
            System.out.println("2. Remove card");
            System.out.println("3. Display card");
            System.out.println("4. Clear cards");
            System.out.println("5. Check if list is empty");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.addCard();
                    break;
                case 2:
                    System.out.print("Enter index of card to remove: ");
                    int removeIndex = scanner.nextInt();
                    list.removeCard(removeIndex);
                    break;
                case 3:
                    System.out.print("Enter index of card to display: ");
                    int displayIndex = scanner.nextInt();
                    list.displayCard(displayIndex);
                    break;
                case 4:
                    list.clearCards();
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("List is not empty");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }
}
