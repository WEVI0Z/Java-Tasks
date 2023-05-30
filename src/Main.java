import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayOfStrings = new ArrayList<String>();

        Collections.addAll(arrayOfStrings, "Alpha", "Zoo", "Beta", "Awz");

        arrayOfStrings.stream().sorted().forEach(System.out::println);

        arrayOfStrings.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}