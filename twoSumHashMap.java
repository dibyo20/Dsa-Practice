import java.util.*;

public class twoSumHashMap {
    public int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(arr[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        twoSumHashMap solu = new twoSumHashMap();
        int arr[] = { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(solu.twoSum(arr, 9)));
    }

}
