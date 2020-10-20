import java.util.*;

public class UniqueWords implements Iterable<String> {

    Set<String> uniqueWords;

    public UniqueWords() {
        uniqueWords = new HashSet<>();
    }

    public void addString(String string) {

        if(string == null) {
            throw new IllegalArgumentException();
        }
        String[] words = string.split("[\\p{Punct}\\s]+");

        uniqueWords.addAll(Arrays.asList(words));

    }


    @Override
    public Iterator<String> iterator() {
        return uniqueWords.iterator();
    }
}
