import java.util.*;

public class majorityElement {
    public static void main(String args[]) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // int key = arr[i];
            // if (map.containsKey(key)) {
            //     map.put(key, map.get(key) + 1);
            // } else {
            //     map.put(key, 1);
            // }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println("Majority Element: " + key);
            }
        }
    }
}
