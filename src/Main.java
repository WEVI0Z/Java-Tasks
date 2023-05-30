import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> setOfNumbers = new HashSet<Integer>();

        setOfNumbers.add(1);
        setOfNumbers.add(2);
        setOfNumbers.add(3);

        HashSet<Integer> secondSetOfNumbers = new HashSet<Integer>((HashSet)setOfNumbers.clone());

        secondSetOfNumbers.forEach(System.out::println);
    }
}