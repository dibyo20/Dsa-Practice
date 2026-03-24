public class rotatedarraysearch {
    public static int search(int[] arr, int tar, int si, int ei) {
        if (si > ei) {
            return -1; // Base case: target not found
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == tar) {
            return mid; // Target found
        }

        if (arr[si] <= arr[mid]) { // Mid is on line 1 or left sorted part
            if (tar >= arr[si] && tar < arr[mid]) {   // Target is in the left sorted part
                return search(arr, tar, si, mid - 1); // Search in the left part
            } else {
                return search(arr, tar, mid + 1, ei); // Search in the right part
            }
        } else { // Mid is on line 2 or right sorted part
            if (tar > arr[mid] && tar <= arr[ei]) {   // Target is in the right sorted part
                return search(arr, tar, mid + 1, ei); // Search in the right part
            } else {
                return search(arr, tar, si, mid - 1); // Search in the left part
            }
        }
    }
    public static void main(String[] args) {    
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(arr, target, 0, arr.length - 1);
        System.out.println("Target found at index: " + result);  // Output -> 4
    }
}
