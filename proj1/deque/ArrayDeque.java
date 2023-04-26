package deque;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private int plusOne(int index) {
        return (index + 1) % array.length;
    }

    private int minusOne(int index) {
        return (index - 1 + array.length) % array.length;
    }

    private void resize(int cap, ArrayDeque<T> src) {
        T[] target = (T[]) new Object[cap];
        int oldIdx = plusOne(src.nextFirst);

        for (int i = 0; i < src.size; i++) {
            target[i] = src.array[oldIdx];
            oldIdx = plusOne(oldIdx);
        }
        array = target;
        nextFirst = cap - 1;
        nextLast = src.size;
        size = src.size;
    }

    private void resize() {
        resize(size * 2, this);
    }

    private boolean isFull() {
        return size == array.length;
    }

    private boolean isSparse() {
        return array.length >= 16 && size < (array.length / 4);
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize();
        }
        array[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize();
        }
        array[nextLast] = item;
        nextLast = plusOne(nextLast);
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
        int idx = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(array[idx] + " ");
            idx = plusOne(idx);
        }
        System.out.println();
    }

    public T removeFirst() {
        nextFirst = plusOne(nextFirst);
        T returnItem = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;

        if (isSparse()) {
            resize();
        }
        return returnItem;
    }

    public T removeLast() {
        nextLast = minusOne(nextLast);
        T returnItem = array[nextLast];
        array[nextLast] = null;
        size -= 1;

        if (isSparse()) {
            resize();
        }
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
        int start = plusOne(nextFirst);
        return array[(start + index) % array.length];
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        ArrayDequeIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T returnItem = (T) get(pos);
            pos += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
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

        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (size() != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T item1 = get(i);
            T item2 = other.get(i);
            if (!item1.equals(item2)) {
                return false;
            }
        }
        return true;
    }
}
