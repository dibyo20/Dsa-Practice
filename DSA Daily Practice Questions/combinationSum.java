import java.util.*;

public class combinationSum {
    public static List<List<Integer>> combSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(candidates, target, 0, list, ans);
        return ans;
    }

    public static void solve(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        list.add(candidates[index]);

        solve(candidates, target - candidates[index], index, list, ans);
        list.remove(list.size() - 1);
        solve(candidates, target, index + 1, list, ans);
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combSum(candidates, target));
    }

}
