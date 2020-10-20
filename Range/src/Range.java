import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int max;
    private int min;
    private boolean downUp;

    public Range(int max, int min, boolean downUp) {
        this.max = max;
        this.min = min;
        this.downUp = downUp;
    }

    public void setDownUp(boolean downUp) {
        this.downUp = downUp;
    }

    public void adjustNumbers() {
        if(min>max) {
             int temp = min;
             min = max;
             max=temp;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int cursor = min;
            private int end = max;
            private boolean downUp = Range.this.downUp;

            @Override
            public boolean hasNext() {
                return cursor <= end;

            }

            @Override
            public Integer next() {
                if (hasNext() && downUp) {
                    int current = cursor;
                    cursor++;
                    return current;

                } else if (hasNext()) {
                    int current = end;
                    end--;
                    return current;
                }
                throw new NoSuchElementException();
            }

        };

    }

}

