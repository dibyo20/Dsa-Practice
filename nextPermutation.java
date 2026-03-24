public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        // If no pivot, reverse the entire array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the successor
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                // Step 3: Swap the pivot and successor
                swap(nums, i, pivot);
                break;
            }
        }
        // Step 4: Reverse the suffix
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        nextPermutation np = new nextPermutation();
        int[] nums = { 1, 2, 3 };
        np.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
