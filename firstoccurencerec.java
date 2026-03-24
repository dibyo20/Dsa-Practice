public class firstoccurencerec {
    public static int firstoccurence(int arr[], int i, int key) {
        if (i >= arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstoccurence(arr, i + 1, key);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        int result = firstoccurence(arr, 0, key);
        System.out.println("First occurrence of " + key + " is at index: " + result);
    }
}
