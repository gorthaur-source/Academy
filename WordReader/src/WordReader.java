import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordReader implements Iterable<String> {

    private final BufferedReader bufferedReader;
    private String line;
    private String[] words;
    private String filePath;
    private FileInputStream stream;
    public WordReader(String filePath) throws IOException {
        this.filePath = filePath;
        bufferedReader = new BufferedReader(new FileReader(filePath));
        line = bufferedReader.readLine();
        words = line.split(" ");
    }

    public void close() {

        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int countLines() {

        FileInputStream stream = null;

        try {
            stream = new FileInputStream(filePath);

            byte[] buffer = new byte[8192];
            int count = 0;
            int n;
            while ((n = stream.read(buffer)) > 0) {
                for (int i = 0; i < n; i++) {
                    if (buffer[i] == '\n') count++;
                }
            }
            stream.close();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException();
    }

    private String readNext() {
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    //  resultString = Regex.Replace(subjectString, @"^\s+$[\r\n]*", "", RegexOptions.Multiline);
    @Override
    public Iterator<String> iterator() {

        return new Iterator<>() {

            private int counter = 0;
            private int numberLines;
            @Override
            public boolean hasNext() {

                numberLines = countLines();
                if (counter < words.length) return true;

                try {

                    for(int i = 0; i<countLines(); i++) {
                        if ((line = bufferedReader.readLine()) != null) {
                            numberLines++;
                            counter = 0;
                            words = line.split(" ");
                            return true;
                        }
                        else continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public String next() {

                if (hasNext()) {
                    String word = words[counter];
                    counter++;
                    return word;
                }
                if (!line.trim().isEmpty() || line.equals("")) {

                }
                System.out.println("No such element");
                throw new NoSuchElementException();
            }


        };
    }
}
