import java.util.*;

public class maxConsecutiveOnesThree {
    public static int maxConsecutiveOnes(int[] arr, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxlength = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(maxConsecutiveOnes(arr, k));
    }
}
