import java.util.*;

public class twoSumTwoSortedArray {
    public static int[] twoSumTwo(int numb[], int target) {
        int left = 0;
        int right = numb.length - 1;

        while (left < right) {
            int sum = numb[left] + numb[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // to start from 1 instead of 0.
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String args[]) {
        int[] numb = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSumTwo(numb, target);
        System.out.println(Arrays.toString(result));
    }
}