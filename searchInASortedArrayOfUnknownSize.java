class UnknownArray {
    private int[] arr;

    public UnknownArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}

public class searchInASortedArrayOfUnknownSize {
    public static int search(UnknownArray arr, int target) {
        int low = 0;
        int high = 1;

        while (arr.get(high) < target) { // Expand the range exponentially
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // If target not found
    }

    public static void main(String[] args) {
        int[] data = { 1, 3, 5, 7, 9, 12, 15, 20, 25, 30 };
        UnknownArray arr = new UnknownArray(data);
        int target = 12;
        System.out.println(search(arr, target));

    }
}
