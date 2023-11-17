package ru.mirea.task10;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node current = head;

            while (current.next != head && current.next.data < newNode.data) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            newNode.next.prev = newNode;

            if (newNode.data < head.data) {
                head = newNode;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(5);
        list.insert(2);
        list.insert(8);
        list.insert(3);
        list.insert(1);

        list.display();
    }
}
