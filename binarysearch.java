public class binarysearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid =  (start + end) / 2;

            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                start = mid + 1; 
            } else {
                end = mid - 1; 
            }
        }
        return -1; 
    }

    public static void main(String[] args){
        int [] arr = {2, 3, 4, 10, 40};
        int target = 10;    
        int result = binarySearch(arr, target);
        if (result == -1) { 
            System.out.println("Element not found in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
