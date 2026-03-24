public class quicksort {
    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return; // Base case: if the subarray has one or no elements, it's already sorted
        }
        int pi = partition(arr, si, ei);   // Getting the partitioning index
        quickSort(arr, si, pi - 1);        // Quicksorting the left subarray
        quickSort(arr, pi + 1, ei);        // Quicksorting the right subarray
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];     // Choosing the last element as pivot
        int i = si - 1;          // Pointer for the smaller element

        for (int j = si; j < ei; j++) {    // Traverse through all elements and compare with pivot and swap
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;  
        // placing the pivot element at the correct position
        int temp = pivot; 
        arr[ei] = arr[i];
        arr[i] = temp; 

        return i; // Return the partitioning index
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
