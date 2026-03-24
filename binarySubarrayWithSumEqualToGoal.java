import java.util.HashMap;

public class binarySubarrayWithSumEqualToGoal { // TC: O(n) SC: O(n), This is Standard Prefix Sum + HashMap approach.
    public static int numberOfSubarrays(int nums[], int goal) {
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

    public int numSubarraysWithSum(int[] nums, int goal) { // TC: O(n) SC: O(1), This is Standard Sliding Window approach, which is more efficient than the above approach.
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) { // TC: O(n) SC: O(1)
        if(goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        binarySubarrayWithSumEqualToGoal obj = new binarySubarrayWithSumEqualToGoal();
        int nums[] = { 1, 0, 1, 0, 1 };
        System.out.println(numberOfSubarrays(nums, 2));
        System.out.println(obj.numSubarraysWithSum(nums, 2));
    }
}
