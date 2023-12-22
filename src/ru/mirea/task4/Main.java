package ru.mirea.task4;

enum TimeOfYear {
    Весна(15), Лето(25), Осень(10), Зима(0);

    private int средняяТемпература;

    TimeOfYear(int средняяТемпература) {
        this.средняяТемпература = средняяТемпература;
    }

    public int getСредняяТемпература() {
        return средняяТемпература;
    }

    public String getDescription() {
        switch (this) {
            case Лето:
                return "Теплое время года";
            default:
                return "Холодное время года";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 2) Создать метод, выводящий информацию о времени года
        TimeOfYear favoriteSeason = TimeOfYear.Лето;
        System.out.println("Мое любимое время года: " + favoriteSeason);
        System.out.println("Средняя температура: " + favoriteSeason.getСредняяТемпература());
        System.out.println("Описание: " + favoriteSeason.getDescription());

        System.out.println("Информация о временах года:");
        for (TimeOfYear season : TimeOfYear.values()) {
            System.out.println("Время года: " + season);
            System.out.println("Средняя температура: " + season.getСредняяТемпература());
            System.out.println("Описание: " + season.getDescription());
            System.out.println();
        }
    }
}
