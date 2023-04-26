package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T maxVal = get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), maxVal) > 0) {
                maxVal = get(i);
            }
        }
        return maxVal;
    }

    public T max() {
        return max(c);
    }
}
