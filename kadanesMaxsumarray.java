public class kadanesMaxsumarray {
    public static void kadanesmaxsumarray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // currentSum += arr[i];
            // if (currentSum < 0) {
            //     currentSum = 0;
            // }
            // if (currentSum > maxSum) {
            //     maxSum = currentSum;
            // }
            maxSum = Math.max(maxSum, currentSum);

        }
        System.out.println("Maximum subarray sum is: " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        kadanesmaxsumarray(arr);
    }
}
