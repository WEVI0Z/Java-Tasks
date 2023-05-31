import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayOfStrings = new ArrayList<String>();

        Collections.addAll(arrayOfStrings, "Alpha", "Coma", "Zoo", "Beta", "Awz");

        arrayOfStrings.stream().sorted(Comparator.comparing(item -> new StringBuilder(item).reverse().toString())).forEach(System.out::println);

        arrayOfStrings.stream().sorted(Collections.reverseOrder(Comparator.comparing(item -> new StringBuilder(item).reverse().toString()))).forEach(System.out::println);
    }
}