public class findPositionOfAnElementInInfiniteSortedArray {
    public static int findPosition(int[] arr, int target) {
        int low = 0;
        int high = 1;

        while (high < arr.length && target > arr[high]) {
            low = high;
            high = high * 2;
            if (high >= arr.length) {
                high = arr.length - 1;
            }
        }
        return binarySearch(arr, target, low, high);
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 9, 12, 15, 18, 21, 25 };
        int target = 15;
        System.out.println(findPosition(arr, target));
    }
}
