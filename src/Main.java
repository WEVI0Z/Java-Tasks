import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();

        arrayOfNumbers.add(1);
        arrayOfNumbers.add(2);
        arrayOfNumbers.add(3);

        arrayOfNumbers.remove(arrayOfNumbers.size() - 1);

        for (int number : arrayOfNumbers) {
            System.out.println(number);
        }
    }
}