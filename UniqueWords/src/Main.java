public class Main {

    public static void main(String[] args) {

        UniqueWords uniqueWords = new UniqueWords();

        uniqueWords.addString("mango banana pineapple mango pineapple edgar edgar.");
        uniqueWords.addString("mango banana pineapple mango pineapple edgar edgar! sup");


        //uniqueWords.printWords();

        for (String s : uniqueWords){
            System.out.println(s);
        }

    }
}
