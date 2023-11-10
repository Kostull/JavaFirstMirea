package ru.mirea.task10;

import java.util.Scanner;

class Element {
    private String name;
    private int age;

    public void readAttributesFromConsole() {
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

class Node {
    private Element element;
    private Node prev;
    private Node next;

    public Node(Element element) {
        this.element = element;
        prev = null;
        next = null;
    }

    public Element getElement() {
        return element;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class List {
    private Node head;
    private Node tail;

    public List() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addElement() {
        System.out.println("Adding a new element...");
        Element element = new Element();
        element.readAttributesFromConsole();

        Node node = new Node(element);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }

        System.out.println("Element added successfully!");
    }

    public void deleteElement() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("Enter the index of the element to delete: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        if (index < 1) {
            System.out.println("Invalid index!");
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("Index out of range!");
            return;
        }

        if (current == head && current == tail) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = current.getNext();
            head.setPrev(null);
        } else if (current == tail) {
            tail = current.getPrev();
            tail.setNext(null);
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }

        System.out.println("Element deleted successfully!");
    }

    public void displayElement() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        System.out.print("Enter the index of the element to display: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        if (index < 1) {
            System.out.println("Invalid index!");
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("Index out of range!");
            return;
        }

        current.getElement().displayAttributes();
    }

    public void clearList() {
        head = null;
        tail = null;
        System.out.println("List cleared successfully!");
    }
}

public class Tester {
    public static void main(String[] args) {
        List list = new List();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add element");
            System.out.println("2. Delete element");
            System.out.println("3. Display element");
            System.out.println("4. Clear list");
            System.out.println("5. Check if Card Index is Empty");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.addElement();
                    break;
                case 2:
                    list.deleteElement();
                    break;
                case 3:
                    list.displayElement();
                    break;
                case 4:
                    list.clearList();
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("Card Index is empty.");
                    } else {
                        System.out.println("Card Index is not empty.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 0);
    }
}
