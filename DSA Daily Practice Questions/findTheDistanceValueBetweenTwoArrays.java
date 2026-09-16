import java.util.*;

public class findTheDistanceValueBetweenTwoArrays {
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int x : arr1) {
            int idx = lowerBound(arr2, x - d);
            if (idx == arr2.length || arr2[idx] > x + d) {
                count++;
            }
        }
        return count;
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 8 };
        int[] arr2 = { 10, 9, 1, 8 };
        int d = 2;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }
}
