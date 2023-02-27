package deque;

public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        private Node(T i, Node n, Node l) {
            item = i;
            next = n;
            prev = l;
        }
    }

    private Node dummy;
    private int size;

    public LinkedListDeque() {
        dummy = new Node(null, null, null);
        dummy.next = dummy;
        dummy.prev = dummy;
        size = 0;
    }

    public void addFirst(T item) {
        dummy.next = new Node(item, dummy.next, dummy);
        dummy.next.next.prev = dummy.next;
        size += 1;
    }

    public void addLast(T item) {
        dummy.prev = new Node(item, dummy, dummy.prev);
        dummy.prev.prev.next = dummy.prev;
        size += 1;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = dummy.next;
        for (int i = 0; i < size(); i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        Node first_Node = dummy.next;
        if (first_Node == dummy) {
            return null;
        }

        size -= 1;
        Node new_first_Node = first_Node.next;
        dummy.next = new_first_Node;
        new_first_Node.prev = dummy;
        return first_Node.item;
    }

    public T removeLast() {
        Node last_Node = dummy.prev;
        if (last_Node == dummy) {
            return null;
        }

        size -= 1;
        Node new_last_Node = last_Node.prev;
        dummy.prev = new_last_Node;
        new_last_Node.next = dummy;
        return last_Node.item;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }

        Node p = dummy.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(Node p, int index) {
        if (p == dummy) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursive(p.next, index - 1);
    }

    public static void main(String[] args) {

    }
}
