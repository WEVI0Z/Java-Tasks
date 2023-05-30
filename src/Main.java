import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> mapOfInteger = new HashMap<String, Integer>();

        mapOfInteger.put("one", 1);

        Map<String, Integer> secondMapOfInteger = new HashMap<String, Integer>();

        secondMapOfInteger.put("two", 2);

        Map<String, Integer> thirdMapOfInteger = new HashMap<String, Integer>(mapOfInteger);

        thirdMapOfInteger.putAll(secondMapOfInteger);

        thirdMapOfInteger.forEach((key, value) -> System.out.printf("Key: %s; Value: %d \n", key, value));
    }
}