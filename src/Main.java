import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Number> setOfNumbers = new HashSet<>();

        setOfNumbers.add(1);
        setOfNumbers.add(2);
        setOfNumbers.add(3);

        HashSet<Integer> secondSetOfNumbers = new HashSet<>();

        secondSetOfNumbers.add(1);
        secondSetOfNumbers.add(4);
        secondSetOfNumbers.add(3);

        HashSet<Integer> finalSetOfNumbers = new HashSet<Integer>((HashSet) setOfNumbers.clone());

        secondSetOfNumbers.forEach(number -> {
            if(!finalSetOfNumbers.contains(number)) {
                finalSetOfNumbers.add(number);
            } else {
                finalSetOfNumbers.remove(number);
            }
        });

        finalSetOfNumbers.forEach(System.out::println);
    }
}