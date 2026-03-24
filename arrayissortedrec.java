public class arrayissortedrec {
    public static boolean isSorted(int[] arr, int i) {
        if (i >= arr.length - 1) {
            return true;
        }

        if (arr[i] <= arr[i + 1]) {
            return isSorted(arr, i + 1);
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        boolean result = isSorted(arr, 0);
        System.out.println("Is the array sorted? " + result);
    }
}
