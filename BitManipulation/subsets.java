import java.util.*;

public class subsets {
    public static List<List<Integer>> sets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int totalMasks = 1 << n;

        for (int mask = 0; mask < totalMasks; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            ans.add(subset);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(sets(nums));
    }
}
