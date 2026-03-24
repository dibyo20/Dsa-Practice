public class averageOfSubarrayOfSizeK {
    public static double[] findAverages(int[] arr, int k) {
        int n = arr.length;

        double[] result = new double[n - k + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        double[] result = findAverages(arr, k);
        for (double num : result) {
            System.out.printf("%.2f ", num); // Here "%.2f" is used to format the output to 2 decimal places.
        }
    }
}
