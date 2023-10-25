package ru.mirea.task7;

public interface MathCalculable {
    double calculatePower(double base, double exponent);
    double calculateComplexModulus(double real, double imaginary);
    double PI = 3.14159265359;
}

class MathFunc implements MathCalculable {
    @Override
    public double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double calculateComplexModulus(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double calculateCircleLength(double radius) {
        return 2 * PI * radius;
    }

    public static void main(String[] args) {
        MathFunc mathFunc = new MathFunc();

        double powerResult = mathFunc.calculatePower(2, 3);
        System.out.println("2 в степени 3 = " + powerResult);

        double modulusResult = mathFunc.calculateComplexModulus(3, 4);
        System.out.println("Модуль комплексного числа 3 + 4i = " + modulusResult);

        double circleLength = mathFunc.calculateCircleLength(5);
        System.out.println("Длина окружности с радиусом 5 = " + circleLength);
    }
}