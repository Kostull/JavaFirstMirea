package ru.mirea.task26;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomListIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int currentIndex;

    public CustomListIterator(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        this.list = list;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        T element = list.get(currentIndex);
        currentIndex++;
        return element;
    }


    public static void main(String[] args) {

        List<String> stringList = List.of("One", "Two", "Three", "Four");

        CustomListIterator<String> iterator = new CustomListIterator<>(stringList);
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

        }
    }
}
