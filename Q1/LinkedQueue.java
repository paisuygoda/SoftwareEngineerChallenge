//Alternative implementation - No use of built-in collection
package Q1;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }


    private Node<T> first;
    private Node<T> last;


    public LinkedQueue() {
        first = null;
        last = null;
    }

    public LinkedQueue<T> deepCopy() {
        LinkedQueue<T> newQueue = new LinkedQueue<>();

        newQueue.first = this.first;
        newQueue.last = this.last;

        return newQueue;
    }

    @Override
    public Queue<T> enQueue(T t) {

        Node<T> newNode = new Node<>(t);

        LinkedQueue<T> newQueue = this.deepCopy();

        if (newQueue.first == null) {
            newQueue.first = newNode;
        } else {
            newQueue.last.next = newNode;
        }

        newQueue.last = newNode;

        return newQueue;
    }

    @Override
    public Queue<T> deQueue() {

        LinkedQueue<T> newQueue = this.deepCopy();

        if (newQueue.first == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        if (newQueue.first == newQueue.last) {
            newQueue.first = null;
            newQueue.last = null;
        } else {
            newQueue.first = newQueue.first.next;
        }

        return newQueue;
    }

    @Override
    public T head() {
        if (first == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
