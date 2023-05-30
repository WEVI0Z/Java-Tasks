import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayOfStrings = new ArrayList<String>();

        Collections.addAll(arrayOfStrings, "one", "Two", "THrEE");

        arrayOfStrings.stream().map(String::toLowerCase).forEach(System.out::println);
    }
}