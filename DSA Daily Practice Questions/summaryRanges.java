import java.util.*;

public class summaryRanges {
    public static List<String> ranges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            int end = nums[i];
            if (start == end) {
                str.append(start);
            } else {
                str.append(start).append("->").append(end);
            }
            res.add(str.toString());
            str = new StringBuilder();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(ranges(nums));
    }
}
