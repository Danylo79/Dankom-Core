package dev.dankom.util.type;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private List<T> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void add(T o) {
        queue.add(0, o);
    }

    public T get() {
        return queue.get(0);
    }

    public void remove() {
        queue.remove(0);
    }
}
