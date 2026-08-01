import java.util.HashMap;

public class continuousSubarraySum {
    public static boolean subarraySum(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if (map.containsKey(rem)) {
                int prevIndex = map.get(rem);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 23, 2, 4, 6, 7 };
        int k = 6;
        System.out.println(subarraySum(nums, k));
    }
}
