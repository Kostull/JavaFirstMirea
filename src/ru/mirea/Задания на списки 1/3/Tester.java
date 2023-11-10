package ru.mirea.task10;

import java.util.Scanner;

class Card {
    String name;
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

class Node {
    Card data;
    Node next;

    public Node(Card data) {
        this.data = data;
        this.next = null;
    }

    public Card getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void addNode(Card data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            newNode.setNext(head);
        } else {
            Node current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
        }
    }

    public void deleteNode(String name) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        ru.mirea.task10.Node currNode = head, prevNode = null;
        do {
            if (currNode.data.name.equals(name)) {
                if (prevNode == null) {
                    ru.mirea.task10.Node lastNode = head;
                    while (lastNode.next != head) {
                        lastNode = lastNode.next;
                    }
                    head = currNode.next;
                    lastNode.next = head;
                } else {
                    prevNode.next = currNode.next;
                }
                System.out.println("Node with name '" + name + "' deleted.");
                return;
            }
            prevNode = currNode;
            currNode = currNode.next;
        } while (currNode != head);

        System.out.println("Node with name '" + name + "' not found.");
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            do {
                current.getData().displayAttributes();
                current = current.getNext();
            } while (current != head);
        }
    }

    public void clearList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class Tester {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add card");
            System.out.println("2. Delete card");
            System.out.println("3. Display cards");
            System.out.println("4. Clear cards");
            System.out.println("5. Check if Card Index is Empty");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Card card = new Card();
                    card.readAttributes();
                    list.addNode(card);
                    break;
                case 2:
                    System.out.print("Enter the name of the card to delete: ");
                    String nameToDelete = scanner.next();
                    list.deleteNode(nameToDelete);
                    break;
                case 3:
                    list.displayList();
                    break;
                case 4:
                    list.clearList();
                    System.out.println("Cards cleared");
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("Card Index is empty.");
                    } else {
                        System.out.println("Card Index is not empty.");
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
