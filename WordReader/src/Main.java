import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        WordReader reader = null;

        try {

            reader = new WordReader("sample-2mb-text-file.txt");


            for (String s : reader) {
                System.out.println(s);
            }
            for (String s : reader) {
                s = s+1;
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader !=null) {
                reader.close();
            }
        }
    }
}
