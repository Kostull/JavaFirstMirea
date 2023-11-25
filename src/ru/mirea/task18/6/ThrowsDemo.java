package ru.mirea.task18;

public class ThrowsDemo {
    public void printMessage(String key) {
        if (key != null) {
            String message = getDetails(key);
            System.out.println(message);
        } else {
            System.out.println("Key cannot be null.");
        }
    }

    public String getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            return "data for " + key;
        } catch (NullPointerException e) {
            return "Exception caught: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();

        try {
            // Вызов с правильным значением
            demo.printMessage("someKey");
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        try {
            // Вызов с нулевым значением
            demo.printMessage(null);
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }
}
