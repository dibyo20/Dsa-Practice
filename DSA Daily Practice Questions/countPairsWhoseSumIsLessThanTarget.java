import java.util.*;

public class countPairsWhoseSumIsLessThanTarget {
    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-1, 1, 2, 3, 1);
        int target = 2;
        System.out.println(countPairs(nums, target));
    }
}
