public class bubblesort {
    public static void bubbleSort(int[] arr) { // TC: O(n^2), SC: O(1)
        int n = arr.length;
        boolean swapped;
        int swap = 0;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swap++;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
        System.out.println("Number of swaps: " + swap);
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int[] arr = {64, 34, 25, 12, 22, 11, 90};
        // int[] arr = {2,0,2,1,1,0};
        int[] arr = {2,1,3,1,2};
        System.out.println("Unsorted array:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
