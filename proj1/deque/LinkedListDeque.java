package deque;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    public class Node {
        T item;
        Node prev;
        Node next;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node dummy;
    private int size;

    public LinkedListDeque() {
        dummy = new Node(null, null, null);
        dummy.prev = dummy;
        dummy.next = dummy;
        size = 0;
    }

    public void addFirst(T item) {
        Node First = new Node(item, dummy, dummy.next);
        dummy.next = First;
        First.next.prev = First;
        size += 1;
    }

    public void addLast(T item) {
        Node Last = new Node(item, dummy.next, dummy);
        dummy.prev.next = Last;
        dummy.prev = Last;
        size += 1;
    }

    public boolean offerFirst(T t) {
        return false;
    }

    public boolean offerLast(T t) {
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public void printDeque() {
        Node p = dummy.next;
        while (p != dummy) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnItem = dummy.next.item;
        Node Second = dummy.next.next;
        dummy.next = Second;
        Second.prev = dummy;
        size -= 1;
        return returnItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T returnItem = dummy.prev.item;
        Node nextLast = dummy.prev.prev;
        dummy.prev = nextLast;
        nextLast.next = dummy;
        size -= 1;
        return returnItem;
    }

    public T pollFirst() {
        return null;
    }

    public T pollLast() {
        return null;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public T peekFirst() {
        return null;
    }

    public T peekLast() {
        return null;
    }

    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    public boolean add(T t) {
        return false;
    }

    public boolean offer(T t) {
        return false;
    }

    public T remove() {
        return null;
    }

    public T poll() {
        return null;
    }

    public T element() {
        return null;
    }

    public T peek() {
        return null;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public void push(T t) {

    }

    public T pop() {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node p = dummy.next;
        while (index > 0) {
            p = p.next;
        }
        return p.item;
    }

    private T getRecursive(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(index, dummy.next);
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node iterNode;

        LinkedListDequeIterator() {
            iterNode = dummy.next;
        }

        public boolean hasNext() {
            return iterNode != dummy;
        }

        public T next() {
            T returnItem = iterNode.item;
            iterNode = iterNode.next;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public Iterator<T> descendingIterator() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }

        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (size() != other.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            T item1 = get(i);
            T item2 = other.get(i);
            if (!item1.equals(item2)) {
                return false;
            }
        }
        return true;
    }
}
