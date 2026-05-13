import java.util.*;

public class longestConsecutiveSequence {
    public static int longestSeq(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int count = 1;

                while(set.contains(currNum+1)){
                    currNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int nums[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestSeq(nums));
    }
}
