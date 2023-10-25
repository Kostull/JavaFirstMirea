package ru.mirea.task6;

import java.util.Scanner;
import java.util.ArrayList;

interface Input {
    Scanner scanner = new Scanner(System.in);

    static ComputerBrand enterBrand() {
        System.out.println("Введите марку компьютера (HP, DELL, ASUS, ACER): ");
        String input = scanner.nextLine().toUpperCase();
        return ComputerBrand.valueOf(input);
    }

    static Processor enterProcessor() {
        System.out.println("Введите модель процессора: ");
        String model = scanner.nextLine();
        return new Processor(model);
    }

    static Memory enterMemory() {
        System.out.println("Введите объем оперативной памяти (в ГБ): ");
        int sizeGB = scanner.nextInt();
        scanner.nextLine();
        return new Memory(sizeGB);
    }

    static Monitor enterMonitor() {
        System.out.println("Введите тип монитора: ");
        String type = scanner.nextLine();
        return new Monitor(type);
    }
}

enum ComputerBrand {
    HP, DELL, ASUS, ACER
}

class Processor {
    private String model;

    public Processor(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class Memory {
    private int sizeGB;

    public Memory(int sizeGB) {
        this.sizeGB = sizeGB;
    }

    public int getSizeGB() {
        return sizeGB;
    }
}

class Monitor {
    private String type;

    public Monitor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Computer {
    private ComputerBrand brand;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(ComputerBrand brand, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    public ComputerBrand getBrand() {
        return brand;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}

class Shop {
    private ArrayList<Computer> computers = new ArrayList<>();

    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Компьютер добавлен в магазин.");
    }

    public void removeComputer(Computer computer) {
        computers.remove(computer);
        System.out.println("Компьютер удален из магазина.");
    }

    public Computer findComputer(ComputerBrand brand, String processorModel, int memorySizeGB, String monitorType) {
        for (Computer computer : computers) {
            if (computer.getBrand() == brand &&
                    computer.getProcessor().getModel().equals(processorModel) &&
                    computer.getMemory().getSizeGB() == memorySizeGB &&
                    computer.getMonitor().getType().equals(monitorType)) {
                return computer;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Shop computerShop = new Shop();

        ComputerBrand brand = Input.enterBrand();
        Processor processor = Input.enterProcessor();
        Memory memory = Input.enterMemory();
        Monitor monitor = Input.enterMonitor();

        Computer computer = new Computer(brand, processor, memory, monitor);

        computerShop.addComputer(computer);

        Computer foundComputer = computerShop.findComputer(brand, processor.getModel(), memory.getSizeGB(), monitor.getType());

        if (foundComputer != null) {
            System.out.println("Найден компьютер:");
            System.out.println("Марка: " + foundComputer.getBrand());
            System.out.println("Процессор: " + foundComputer.getProcessor().getModel());
            System.out.println("Оперативная память: " + foundComputer.getMemory().getSizeGB() + " ГБ");
            System.out.println("Монитор: " + foundComputer.getMonitor().getType());
        } else {
            System.out.println("Компьютер не найден в магазине.");
        }
    }
}
