import java.util.Arrays;

public class maximumSumOfThreeNonOverlappingSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int windowSum[] = new int[n - k + 1];
        int sum = 0;

        for (int i = 0; i < n; i++) { // Here we are calculating the sum of every possible subarray of size k and
                                      // storing it in the windowSum array.
            sum += nums[i];

            if (i >= k) {
                sum -= nums[i - k];
            }

            if (i >= k - 1) {
                windowSum[i - k + 1] = sum;
            }
        }

        int left[] = new int[windowSum.length];
        int best = 0;

        for (int i = 0; i < windowSum.length; i++) { // Here we are calculating the index of the maximum sum of the
                                                     // subarray on the left side of the current index and storing it in
                                                     // the left array.
            if (windowSum[i] > windowSum[best]) {
                best = i;
            }
            left[i] = best;
        }

        int right[] = new int[windowSum.length];
        best = windowSum.length - 1;

        for (int i = windowSum.length - 1; i >= 0; i--) { // Here we are calculating the index of the maximum sum of the
                                                          // subarray on the right side of the current index and storing
                                                          // it in the right array.
            if (windowSum[i] >= windowSum[best]) {
                best = i;
            }
            right[i] = best;
        }

        int ans[] = new int[3];
        int maxTotal = 0;

        for (int mid = k; mid < windowSum.length - k; mid++) { // Here we are calculating the total sum of the three
                                                               // subarrays by using the left and right arrays to get
                                                               // the index of the maximum sum of the subarray on the
                                                               // left and right side of the current index and adding it
                                                               // to the sum of the current index to get the total sum
                                                               // of the three subarrays.
            int leftIdx = left[mid - k];
            int rightIdx = right[mid + k];
            int total = windowSum[leftIdx] + windowSum[mid] + windowSum[rightIdx];

            if (total > maxTotal) { // Here we are checking if the total sum of the three subarrays is greater than
                                    // the maximum total sum we have seen so far, if it is then we update the
                                    // maximum total sum and the answer array with the indices of the three
                                    // subarrays.
                maxTotal = total;
                ans[0] = leftIdx;
                ans[1] = mid;
                ans[2] = rightIdx;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 6, 7, 5, 1 };
        int k = 2;
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(nums, k)));
    }
}
