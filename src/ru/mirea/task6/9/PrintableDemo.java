package ru.mirea.task6;

import  java.util.Objects;

interface Printable {
    void print();
}

class Book implements Printable {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Printing book " + getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + '}';
    }
}

class Shop implements Printable {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Print Shop " + getName());
    }

    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public  String toString() {
        return "Shop(" + "name='" + name + '\'' + ')';
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Book1");
        Book book2 = new Book("Book2");
        Shop shop1 = new Shop("Shop1");
        Shop shop2 = new Shop("Shop2");

        Printable[] printables = {book1, book2, shop1, shop2};
        for (Printable printable:printables) {
            printable.print();
        }
    }
}
