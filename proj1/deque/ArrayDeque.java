package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;       // amount of current valid element.
    private int next_First_idx;     // Points to the index of previous box of the first element.
    private int next_Last_idx;      // Points to the index of next box of the last element.

    /**
     * Create an empty Array.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        next_First_idx = 0;
        next_Last_idx = 1;
    }

    private int plusOne(int idx) {
        return (idx + 1) % items.length;
    }

    private int minusOne(int idx) {
        return (idx - 1 + items.length) % items.length;
    }

    /**
     * @param capacity
     * @param src
     */
    private void resize(int capacity, ArrayDeque<T> src) {
        T[] temp = (T[]) new Object[capacity];
        int oldIdx = plusOne(src.next_First_idx);

        System.arraycopy(src, oldIdx, temp, 0, src.size());
        items = temp;
        next_First_idx = capacity - 1;
        next_Last_idx = src.size();
    }

    private void resize(int capacity) {
        resize(capacity, this);
    }

    private void upSize() {
        resize(size * 2);
    }

    private void downSize() {
        resize(size / 2);
    }

    private boolean isFull() {
        return size == items.length;
    }

    private boolean isSparse() {
        return items.length >= 16 && size < items.length / 4;
    }

    public void addFirst(T item) {
        if (isFull())
            upSize();

        items[next_First_idx] = item;
        next_First_idx = minusOne(next_First_idx);
        size += 1;
    }

    public void addLast(T item) {
        if (isFull())
            upSize();
        
        items[next_Last_idx] = item;
        next_Last_idx = plusOne(next_Last_idx);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        int index = plusOne(next_First_idx);
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = plusOne(index);
        }
        System.out.println();
    }

    public T removeFirst() {
        int First_idx = plusOne(next_First_idx);
        T res = items[First_idx];
        items[First_idx] = null;
        size -= 1;
        next_First_idx = First_idx;

        if (isSparse()) downSize();
        return res;
    }

    public T removeLast() {
        int Last_idx = minusOne(next_Last_idx);
        T res = items[Last_idx];
        items[Last_idx] = null;
        size -= 1;
        next_Last_idx = Last_idx;

        if (isSparse()) downSize();
        return res;
    }

    public T get(int index) {
        if (index >= size)
            return null;

        int First_idx = plusOne(next_First_idx);
        int target_idx = (First_idx + index) % items.length;
        return items[target_idx];
    }

    public static void main(String[] args) {

    }
}
