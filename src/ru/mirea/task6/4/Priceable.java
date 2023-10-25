package ru.mirea.task6;

public interface Priceable {
    double getPrice();
}

class Product implements Priceable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Service implements Priceable {
    private String serviceName;
    private double hourlyRate;

    public Service(String serviceName, double hourlyRate) {
        this.serviceName = serviceName;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPrice() {
        return hourlyRate;
    }
}

class Subscription implements Priceable {
    private String subscriptionName;
    private double monthlyFee;

    public Subscription(String subscriptionName, double monthlyFee) {
        this.subscriptionName = subscriptionName;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public double getPrice() {
        return monthlyFee;
    }
}

class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Ноутбук", 999.99);
        Service consulting = new Service("Консультация", 50.00);
        Subscription gymMembership = new Subscription("Абонемент в зал", 30.00);

        System.out.println("Цена за ноутбук: $" + laptop.getPrice());
        System.out.println("Цена за консультацию: $" + consulting.getPrice());
        System.out.println("Месячная цена за абонемент: $" + gymMembership.getPrice());
    }
}
