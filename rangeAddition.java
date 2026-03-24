import java.util.Arrays;

public class rangeAddition {
    public static int[] rangeAdd(int updates[][], int length) {
        int[] arr = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            arr[start] += val;
            if (end + 1 < length) {
                arr[end + 1] -= val;
            }
        }

        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {
                { 1, 3, 2 },
                { 2, 4, 3 },
                { 0, 2, -2 }
        };
        System.out.println(Arrays.toString(rangeAdd(updates, length)));
    }
}
