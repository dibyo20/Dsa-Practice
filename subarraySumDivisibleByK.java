import java.util.HashMap;

public class subarraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            int remainder = (prefixSum % k + k) % k; // This handles negative remainders, like if prefixSum is -1 and k is 5, we want the remainder to be 4 instead of -1, so we add k to it and then take modulo k again, which gives us the correct positive remainder i.e. ( -1 % 5 + 5 ) % 5 = ( -1 + 5 ) % 5 = 4 % 5 = 4.
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }
}
