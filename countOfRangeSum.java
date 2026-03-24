public class countOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private static int mergeSort(long[] arr, int low, int high, int lower, int upper) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int count = mergeSort(arr, low, mid, lower, upper) // This is the count of range sums in the left half
                  + mergeSort(arr, mid + 1, high, lower, upper); // This is the count of range sums in the right half

        int j = mid + 1, k = mid + 1;
        for (int i = low; i <= mid; i++) { // This loop counts the number of valid range sums that start in the left half and end in the right half

            while (k <= high && arr[k] - arr[i] < lower) k++;
            while (j <= high && arr[j] - arr[i] <= upper) j++;

            count += (j - k);
        }

        long[] temp = new long[high - low + 1]; // From here normal merge is done to sort the left and right halves, as done in merge sort.
        int left = low, right = mid + 1, idx = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }
        while (left <= mid) temp[idx++] = arr[left++];
        while (right <= high) temp[idx++] = arr[right++];
        System.arraycopy(temp, 0, arr, low, temp.length);
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { -2, 5, -1 };
        int lower = -2, upper = 2;
        System.out.println(countRangeSum(nums, lower, upper));
    }
}
