public class preffixsubarraysum {
    public static void preffixSubArraySum(int arr[], int n) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0]; 

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i]; // Calculate prefix sum
        }

        for (int i = 0; i < n; i++) {
            int start = i;
            for (int j = i; j < n; j++) {
                currSum = 0; 
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1]; // Calculate the sum using prefix array
                if(currSum > maxSum) {
                    maxSum = currSum; 
                }
            }
        }
        System.out.println("Max Sum " + maxSum);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        preffixSubArraySum(arr, n);
    }
}
