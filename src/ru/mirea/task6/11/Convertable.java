package ru.mirea.task6;

import java.util.Scanner;

public interface Convertable {
    double convert(double input);
}

class CelsiusToKelvinConverter implements Convertable {
    @Override
    public double convert(double input) {
        return input + 273.15;
    }
}

class CelsiusToFahrenheitConverter implements Convertable {
    @Override
    public double convert(double input) {
        return (input * 9/5) + 32;
    }
}

class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите градусы по Цельсию: ");
        double celsiusTemperature = scanner.nextDouble();

        Convertable toKelvin = new CelsiusToKelvinConverter();
        Convertable toFahrenheit = new CelsiusToFahrenheitConverter();

        double kelvinTemperature = toKelvin.convert(celsiusTemperature);
        double fahrenheitTemperature = toFahrenheit.convert(celsiusTemperature);

        System.out.println(celsiusTemperature + " градусов Цельсия равны " + kelvinTemperature + " Кельвинам");
        System.out.println(celsiusTemperature + " градусов Цельсия равны " + fahrenheitTemperature + " Фаренгейтам");
    }
}
