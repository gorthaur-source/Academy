import java.util.Iterator;

public class Range implements Iterable<Integer> {


    private final int max;
    private final int min;

    public Range(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new rangeIterator(max, min);

    }
}
