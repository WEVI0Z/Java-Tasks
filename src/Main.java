import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> setOfNumbers = new HashMap<>();

        setOfNumbers.put("one", 1);
        setOfNumbers.put("two", 2);
        setOfNumbers.put("three", 3);

        HashMap<String, Integer> secondSetOfNumbers = new HashMap<String, Integer>((HashMap)setOfNumbers.clone());

        secondSetOfNumbers.keySet().forEach(System.out::println);
        secondSetOfNumbers.values().forEach(System.out::println);
    }
}