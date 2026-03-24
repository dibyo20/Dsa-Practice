public class maxsubarraysum {
    public static void maxSubArraySum(int arr[], int n) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k]; // Calculate the sum of the current subarray
                }
                System.out.println(currSum);
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max Sum " + maxSum);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int n = arr.length;
        maxSubArraySum(arr, n);
    }
}
