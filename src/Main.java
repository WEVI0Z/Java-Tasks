import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Number> setOfNumbers = new HashSet<>();

        setOfNumbers.add(1);
        setOfNumbers.add(2);
        setOfNumbers.add(3);

        HashSet<Number> secondSetOfNumbers = new HashSet<>();

        secondSetOfNumbers.add(1);
        secondSetOfNumbers.add(2);
        secondSetOfNumbers.add(3);

        System.out.println(setOfNumbers.equals(secondSetOfNumbers));
    }
}