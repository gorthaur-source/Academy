import java.util.stream.IntStream;

public class PerfectNumber {


    public static void main(String[] args) {

        checkPerfect(1, 100000);

    }


    public static int sumDivisors(int num) {
        return IntStream.range(1, num).
                filter(x -> num % x == 0).
                sum();
    }


    public static void checkPerfect(int min, int max) {
        IntStream.range(min, max).
                filter(n -> n == sumDivisors(n))
                .parallel()
                .forEach(System.out::println);
    }

    public int sumDivisorsBetter(int n) {
        int root = (int) Math.sqrt(n);
        int sum = IntStream.range(2, root + 1)
                .filter(x -> n % x == 0)
                .map(x ->)
    }

    public void checkPerfectBetter(int limit) {
        IntStream.iterate(1, n -> n + 1)
                .unordered()
                .filter(n -> n == sumDivisorsBetter(n))
                .limit(limit)
                .forEach(System.out::println);
    }
}
