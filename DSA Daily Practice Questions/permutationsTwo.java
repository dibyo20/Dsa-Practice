import java.util.*;

public class permutationsTwo {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        solve(nums, ans, permute, vis);
        return ans;
    }

    private static void solve(int[] nums, List<List<Integer>> ans, List<Integer> permute, boolean[] vis) {
        if (permute.size() == nums.length) {
            ans.add(new ArrayList<>(permute));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]){
                continue;
            }

            if(i>0 && nums[i] == nums[i-1] && !vis[i-1]){
                continue;
            }

            vis[i] = true;
            permute.add(nums[i]);
            solve(nums, ans, permute, vis);
            permute.remove(permute.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
