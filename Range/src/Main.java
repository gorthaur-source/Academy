import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Range range = new Range(5, 20, false) ;

        range.adjustNumbers();

        for (Integer integer : range) {
            System.out.println(integer);

            if (integer == 10) {
                range.setDownUp(true);
            }
        }

        range.setDownUp(true);

        for (Integer integer : range) {
            System.out.println(integer);
        }
    }
}
