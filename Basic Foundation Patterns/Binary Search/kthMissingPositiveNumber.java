public class kthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int[] missing = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            missing[i] = arr[i] - i - 1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (missing[mid] >= k) {
                right = mid - 1;
            } else if (missing[mid] < k) {
                left = mid + 1;
            }
        }
        return left + k;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
}
