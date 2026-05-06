import java.util.*;

public class slidingWindowMaximum {
    public static int[] maxWindow(int[] arr, int k) {
        int n = arr.length;
        int res[] = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                res[index++] = arr[dq.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] res = maxWindow(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
