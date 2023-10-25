package ru.mirea.task6;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void update();
}

class ObservableStringBuilder {

    private final StringBuilder stringBuilder;
    private final List<Observer> observers;

    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.observers = new ArrayList<>();
    }

    public void append(String str) {
        stringBuilder.append(str);
        notifyObservers();
    }

    public void delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }
}

class StringObserver implements Observer {
    private final ObservableStringBuilder observableStringBuilder;

    public StringObserver(ObservableStringBuilder observableStringBuilder) {
        this.observableStringBuilder = observableStringBuilder;
        this.observableStringBuilder.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Строка была изменена. Новое содержимое: " + observableStringBuilder.toString());
    }
}

class Main {
    public static void main(String[] args) {
        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder();
        StringObserver observer = new StringObserver(observableStringBuilder);

        observableStringBuilder.append("Hello, ");
        observableStringBuilder.append("world!");
        observableStringBuilder.delete(5, 12);
    }
}