import java.util.*;

public class uniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int count : map.values()) {
            if (!set.add(count)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 1, 3 };
        System.out.println(uniqueOccurrences(arr));
    }
}
