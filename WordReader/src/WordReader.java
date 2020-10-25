import java.io.*;
import java.util.Iterator;

public class WordReader implements Iterable<String> {

    String filePath;
    BufferedReader bufferedReader;
    LineNumberReader lineNumberReader;
    String line;
    String[] words;

    public WordReader(String filePath) throws IOException {
        this.filePath = filePath;
        bufferedReader = new BufferedReader(new FileReader(filePath));
        lineNumberReader = new LineNumberReader(bufferedReader);
        line = bufferedReader.readLine();
        words = line.split(" ");

    }

    protected void close() {

        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Iterator<String> iterator() {
        try {
            return new Iterator<>() {

                String word;
                int counter = 0;

                @Override
                public boolean hasNext() {
                    try {
                        if (counter < words.length) return true;
                        if ((line = bufferedReader.readLine()) != null) {
                            counter = 0;
                            words = line.split(" ");
                            return true;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                }


                @Override
                public String next() {
                        word = words[counter];
                        counter++;
                        return word;

                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

