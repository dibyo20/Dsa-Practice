public class countOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    public static int mergeSort(long[] prefix, int low, int high, int lower, int upper) {
        if (low >= high)
            return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(prefix, low, mid, lower, upper) + mergeSort(prefix, mid + 1, high, lower, upper);

        int j = mid + 1, k = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (k <= high && prefix[k] - prefix[i] < lower)
                k++;
            while (j <= high && prefix[j] - prefix[i] <= upper)
                j++;

            count += j - k;
        }

        long[] temp = new long[high - low + 1];
        int left = low, right = mid + 1, idx = 0;
        while (left <= mid && right <= high) {
            if (prefix[left] < prefix[right]) {
                temp[idx++] = prefix[left++];
            } else {
                temp[idx++] = prefix[right++];
            }
        }

        while (left <= mid)
            temp[idx++] = prefix[left++];
        while (right <= high)
            temp[idx++] = prefix[right++];
        System.arraycopy(temp, 0, prefix, low, temp.length);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 5, -1 };
        int lower = -2, upper = 2;
        System.out.println(countRangeSum(nums, lower, upper));
    }
}
