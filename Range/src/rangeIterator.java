import java.util.Iterator;

public class rangeIterator implements Iterator<Integer> {

    private int cursor;
    private final int end;

    public rangeIterator(Integer max, Integer min) {
        this.cursor = min;
        this.end = max;
    }

    @Override
    public boolean hasNext() {
        return cursor <= end;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int current = cursor;
            cursor++;
            return current;
        }
        return -1;
    }

}
