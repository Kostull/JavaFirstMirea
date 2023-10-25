package ru.mirea.task6;

public interface Nameable {
    String getName();
}


class Planet implements Nameable {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Car implements Nameable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Animal implements Nameable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Nameable planet = new Planet("Земля");
        Nameable car = new Car("Lamborghini Diablo");
        Nameable animal = new Animal("Енот");

        System.out.println("Имя планеты: " + planet.getName());
        System.out.println("Имя автомобиля: " + car.getName());
        System.out.println("Имя животного: " + animal.getName());
    }
}
