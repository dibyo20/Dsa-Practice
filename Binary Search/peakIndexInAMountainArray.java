public class peakIndexInAMountainArray {
    public static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int largest = Integer.MIN_VALUE;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                if (arr[mid] > largest) {
                    largest = mid;
                    end = mid;
                }
            } else {
                if (arr[mid + 1] > largest) {
                    largest = mid + 1;
                }
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(findPeakIndex(arr));
    }
}
