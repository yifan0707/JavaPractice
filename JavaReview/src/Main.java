import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        int result = test.numberOfDigits(123);
        System.out.println(result);

        //Iterator Example
        WordSet wordSet = new WordSet();
        wordSet.add("apple1");
        wordSet.add("apple2");
        wordSet.add("apple3");
        Iterator<String> iterator = wordSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //recursion
    private int numberOfDigits(int number) {
        if(number > -10 && number < 10) {
            return 1;
        } else {
            return numberOfDigits(number / 10) + 1;
        }
    }

}
