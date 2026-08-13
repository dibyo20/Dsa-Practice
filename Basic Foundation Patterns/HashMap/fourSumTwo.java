import java.util.*;

public class fourSumTwo {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum = nums3[k] + nums4[l];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                ans += map.getOrDefault((-sum), 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2 };
        int nums2[] = { -2, -1 };
        int nums3[] = { -1, 2 };
        int nums4[] = { 0, 2 };
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
