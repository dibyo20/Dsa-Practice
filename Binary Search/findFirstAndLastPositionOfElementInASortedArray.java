public class findFirstAndLastPositionOfElementInASortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int firstPos = searchFirst(nums, target);
        int lastPos = searchLast(nums, target);
        return new int[] { firstPos, lastPos };
    }

    public static int searchFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int searchLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 3 };
        int target = 2;
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        System.out.println(first + " " + last);
    }
}
