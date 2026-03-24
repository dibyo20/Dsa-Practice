import java.util.*;

public class slidingWindowMaximumOptimal { // This is the optimal monotonic queue solution for the sliding window maximum problem. 

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) { // This loop ensures that the elements in the deque are within the current window. If the front of the deque is out of the current window, then it is removed from the deque.
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) { // This loop ensures that the elements in the deque are in decreasing order and the maximum element is at the front of the deque.
                dq.pollLast();
            }

            dq.offerLast(i); // Add the current element's index to the deque.

            if (i >= k - 1) {
                res[index++] = arr[dq.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int[] result = maxSlidingWindow(arr, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
