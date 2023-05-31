import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();

        Collections.addAll(arrayOfNumbers, 3, 4, 2, 6, 1, 9, 8);

        int firstNumber = arrayOfNumbers.stream().
                sorted().
                skip(1).
                findFirst().get();

        int secondNumber = arrayOfNumbers.stream().
                sorted(Collections.reverseOrder()).
                skip(1).
                findFirst().get();

        System.out.printf("Second smallest: %d; Second biggest: %d", firstNumber,  secondNumber);
    }
}