import java.util.HashMap;

public class duplicateArrayNum {
    public static void main(String args[]) { // Tc: O(n)
        int arr[] = { 10, 2, -2, -20, 10 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < arr.length; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1); // Store the count of occurrences of the number
        }

        for (int j = 0; j < arr.length; j++) {
            if (map.get(arr[j]) > 1) {
                System.out.println(arr[j]);
                return;
            }
        }

    }
}
