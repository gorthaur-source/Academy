import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Range range = new Range(10, 5) ;

        for (Integer integer : range) {
            System.out.println(integer);
        }
            
    }
}
