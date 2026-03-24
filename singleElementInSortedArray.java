public class singleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate(arr));
    }
}

// Note: in general every pairs start at even index. If mid is odd, we decrement it by 1 to make it even. 
// If the element at mid is equal to the next element, it means the single element is in the right half, so we move start to mid + 2. Otherwise, we move end to mid. 
// This process continues until start meets end, which will be the single non-duplicate element.
