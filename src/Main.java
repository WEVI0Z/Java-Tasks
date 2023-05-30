import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();

        arrayOfNumbers.add(1);
        arrayOfNumbers.add(2);
        arrayOfNumbers.add(3);

        Collections.reverse(arrayOfNumbers);

        arrayOfNumbers.forEach(System.out::println);
    }
}