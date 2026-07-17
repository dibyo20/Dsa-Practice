import java.util.*;

public class intersectionOfTwoArrays {
    public static int[] intersetArr(int nums1[], int nums2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int[] ans = new int[nums1.length];

        int idx = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                ans[idx] = nums2[i];
                idx++;
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOf(ans, idx);
    }

    public static void main(String args[]) {
        int nums1[] = { 1, 2, 2, 1 };
        int nums2[] = { 2, 2 };
        System.out.println(Arrays.toString(intersetArr(nums1, nums2)));
    }
}
