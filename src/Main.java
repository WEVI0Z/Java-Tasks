import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayOfStrings = new ArrayList<String>();

        Collections.addAll(arrayOfStrings, "Work", "Fly", "workbench");

        arrayOfStrings
                .stream()
                .filter(string -> string.toLowerCase().charAt(0) == 'w')
                .forEach(System.out::println);
    }
}