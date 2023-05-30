import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayOfStrings = new ArrayList<String>();

        Collections.addAll(arrayOfStrings, "Alpha", "Zoo", "Beta", "Awz");

        arrayOfStrings.stream().sorted().collect(Collectors.toCollection(LinkedList::new)).descendingIterator().forEachRemaining(System.out::println);
    }
}