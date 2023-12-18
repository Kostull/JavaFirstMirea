package ru.mirea.task26;

import java.util.Stack;

class ArrayInverter {

    public static void invertArrayWithStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Заполняем стек элементами из исходного массива
        for (int elem : arr) {
            stack.push(elem);
        }

        // Меняем местами элементы массива, используя стек
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        // Пример использования
        int[] originalArray = {1, 2, 3, 4, 5};

        System.out.print("Исходный массив: ");
        printArray(originalArray);

        invertArrayWithStack(originalArray);

        System.out.print("Инвертированный массив: ");
        printArray(originalArray);
    }

    // Вспомогательный метод для печати массива
    private static void printArray(int[] arr) {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
