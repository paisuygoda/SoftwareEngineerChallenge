package Q1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T> {

    //java.util.LinkedList is mutable
    private LinkedList<T> data;

    public ImmutableQueue() {
        data = new LinkedList<T>();
    }

    public ImmutableQueue(LinkedList<T> data) {
        this();
        if (data != null) {
            //LinkedList do not have deep copy method so addAll
            this.data.addAll(data);
        }
    }

    @Override
    public Queue<T> enQueue(T t) {
        ImmutableQueue<T> newQueue = new ImmutableQueue<>(data);
        newQueue.data.add(t);
        return newQueue;
    }

    @Override
    public Queue<T> deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        ImmutableQueue<T> newQueue = new ImmutableQueue<>(data);
        newQueue.data.pop();
        return newQueue;
    }

    @Override
    public T head() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return data.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
