public class largestsmallest {
    public static void findLargestSmallest(int arr[]) {
        int largest = Integer.MIN_VALUE; // Initialize to the smallest possible integer
        int smallest = Integer.MAX_VALUE; // Initialize to the largest possible integer
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i]; 
                if (arr[i] < smallest) {
                    smallest = arr[i];
                }
            }
        }
        System.out.println("The smallest element in the array is: " + smallest); 
        System.out.println("The largest element in the array is: " + largest); 
        return; 
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, 6, 8, 10 }; 
        findLargestSmallest(arr);
    }
}
