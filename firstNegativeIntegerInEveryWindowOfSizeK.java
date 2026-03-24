import java.util.*;

public class firstNegativeIntegerInEveryWindowOfSizeK {

    public static int[] firstNegative(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] < 0) {
                dq.addLast(i);
            }

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Note: The window is just a concept and we are not actually creating a window
            // using iteration or variables but we are just checking the condition for the
            // window and then adding the result to the result array.
            // "The window is in just a vision in our mind to solve the problem".

            if (i >= k - 1) {
                if (dq.isEmpty()) {
                    result[index++] = 0; // If no negative number in the current window, then '0' is added to the result array.
                } else {
                    result[index++] = arr[dq.peekFirst()];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        System.out.println(Arrays.toString(firstNegative(arr, k)));
    }

}
