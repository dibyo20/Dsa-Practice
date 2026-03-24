import java.util.HashMap;
import java.util.Map;

public class makeSumDivisibleByP {
    public static int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;
        int target = (int)(total % p);
        if (target == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int needed = (prefix - target + p) % p;
            if (map.containsKey(needed)) {
                res = Math.min(res, i - map.get(needed));
            }
            map.put(prefix, i);
        }
        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        int nums[] = {3,1,4,2};
        int p = 6;
        System.out.println(minSubarray(nums, p));
    }
}
