import java.util.*;

public class permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(nums, ans, permute, vis, 0);
        return ans;
    }

    private static void solve(int[] nums, List<List<Integer>> ans, List<Integer> permute, boolean[] vis, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(permute));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                permute.add(nums[i]);
                solve(nums, ans, permute, vis, idx + 1);
                permute.remove(permute.size() - 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
