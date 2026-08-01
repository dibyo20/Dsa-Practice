import java.util.HashMap;

public class binarySubarraysWithSum {
    public static int countBinarySubarrays(int nums[], int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - goal)) {
                count += map.get(prefixSum - goal);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(countBinarySubarrays(nums, goal));
    }
}
