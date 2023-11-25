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
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.printMessage(null);
    }
}
