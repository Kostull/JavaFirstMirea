package ru.mirea.task7;

public interface StringManipulation {
    int countCharacters(String s);
    String oddPositionCharacters(String s);
    String reverseString(String s);
}

class Main implements StringManipulation {
    @Override
    public int countCharacters(String s) {
        return s.length();
    }

    @Override
    public String oddPositionCharacters(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder(s);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        StringManipulation manipulation = new Main();
        String input = "Hello, World!";

        int charCount = manipulation.countCharacters(input);
        String oddPosChars = manipulation.oddPositionCharacters(input);
        String reversed = manipulation.reverseString(input);

        System.out.println("Количество символов в строке: " + charCount);
        System.out.println("Строка с символами на нечетных позициях: " + oddPosChars);
        System.out.println("Инвертированная строка: " + reversed);
    }
}