package ru.mirea.task23;

public interface Queue {
    Object dequeue();
    Object element();
    void enqueue(Object o);
    boolean isEmpty();
    boolean clear();
}
