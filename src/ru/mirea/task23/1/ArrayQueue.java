package ru.mirea.task23;

public class ArrayQueue {
    private ArrayQueueModule queue;

    public ArrayQueue(){
        this.queue = ArrayQueueModule.getInstance();
    }

    // PRE: size > 0
    // POST: R = queue[head]
    //       queue[head] = queue[head+1]
    //       queue[head+1]..queue[tail] - immutable
    public Object dequeue() {
        return queue.dequeue();
    }

    // PRE:  size > 0
    // POST: R = queue[head]
    //       queue - immutable
    public Object element() {
        return queue.element();
    }

    // PRE:  None
    // POST: queue[tail] = element
    //       queue[head]..queue[tail-1] - immutable
    public void enqueue(Object o) {
        queue.enqueue(o);
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = (head == tale)
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // PRE:  None
    // POST: size == 0
    public boolean clear() {
        return queue.clear();
    }
}
