public class mergesort {
    public static void mergeSort(int[] arr, int si, int ei) {  // TC: O(n log n), SC: O(n)
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // Sort the left half
        mergeSort(arr, mid + 1, ei); // Sort the right half
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;          // Starting index for left subarray
        int j = mid + 1;     // Starting index for right subarray
        int k = 0;           // Starting index for temporary array

        while(i <= mid && j <= ei) {     // Comapring elements from both halves
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {       // Copy remaining elements from left subarray
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= ei) {       // Copy remaining elements from right subarray
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0, i = si; k < temp.length; k++, i++) {        // Copy sorted elements back to original array
            arr[i] = temp[k];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        int[] arr = {2,0,2,1,1,0};
        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
