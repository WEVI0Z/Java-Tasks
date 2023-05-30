import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> mapOfInteger = new HashMap<>();

        mapOfInteger.put("one", 1);
        mapOfInteger.put("two", 2);
        mapOfInteger.put("three", 3);

        Set<String> keys = mapOfInteger.keySet();

        keys.forEach(System.out::println);
    }
}