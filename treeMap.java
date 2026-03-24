import java.util.*;

public class treeMap {
    public static void main(String args[]) {
        TreeMap<String, Integer> map = new TreeMap<>();  // sorted by keys i.e., alphabetical order
        map.put("India", 1);
        map.put("USA", 2);
        map.put("China", 3);
        map.put("Japan", 4);
        map.put("Germany", 5);
        map.put("France", 6);

        System.out.println("Initial map: " + map);

        
        // int bananaCount = map.get("banana");
        // System.out.println("Count of bananas: " + bananaCount);

        // System.out.println(map.containsKey("apple"));

        // System.out.println(map.containsValue(3));

        // map.remove("grape");
        // System.out.println("Map after removing grape: " + map);

        // System.out.println(map.size());

        // Iterate through the map
        // Set<String> keys = map.keySet();
        // System.out.println("Keys in the map: " + keys);

        // for (String k : keys) {
        //     System.out.println("Key: " + k + ", Value: " + map.get(k));
        // }
    }
}
