import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();

        Collections.addAll(arrayOfNumbers, 3, 4, 2, 6, 1, 9, 8);

        List<Integer> numbers = arrayOfNumbers.stream().sorted().toList();

        System.out.printf("Second smallest: %d; Second biggest: %d", numbers.get(1),  numbers.get(numbers.size() - 2));
    }
}