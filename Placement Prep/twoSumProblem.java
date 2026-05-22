import java.util.Arrays;

public class twoSumProblem {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 13;
        int result[] = new int[2];
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
