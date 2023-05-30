import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> arrayOfNumbers = new LinkedList<>();

        arrayOfNumbers.add(1);
        arrayOfNumbers.add(2);
        arrayOfNumbers.add(3);

        Collections.shuffle(arrayOfNumbers);

        arrayOfNumbers.forEach(System.out::println);
    }
}