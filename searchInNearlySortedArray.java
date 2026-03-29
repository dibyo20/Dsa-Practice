public class searchInNearlySortedArray {
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) // Check mid
                return mid;
            if (mid - 1 >= low && arr[mid - 1] == target) // Check mid - 1
                return mid - 1;
            if (mid + 1 <= high && arr[mid + 1] == target) // Check mid + 1
                return mid + 1;

            if (target < arr[mid]) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 3, 40, 20, 50, 80, 70 };
        int target = 40;
        System.out.println(search(arr, target));
    }
}
