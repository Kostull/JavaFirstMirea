package ru.mirea.task20;

import java.io.Serializable;

interface Animal {
}

class GenericClass<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T t;
    private V v;
    private K k;

    public GenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printClassNames() {
        System.out.println("Type of T: " + t.getClass().getName());
        System.out.println("Type of V: " + v.getClass().getName());
        System.out.println("Type of K: " + k.getClass().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        String str = "Hello";
        Dog dog = new Dog();
        Integer integer = 42;

        GenericClass<String, Dog, Integer> myGenericClass = new GenericClass<>(str, dog, integer);

        myGenericClass.printClassNames();
    }
}

class Dog implements Animal, Serializable {
}
