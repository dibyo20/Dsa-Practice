public class lastoccurencerec {
    public static int lastOccurrence(int[] arr, int key, int n) {
        if (n == 0) {
            return -1; 
        }

        if (arr[n - 1] == key) {
            return n - 1; 
        }
        return lastOccurrence(arr, key, n - 1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 6};
        int key = 3;
        int n = arr.length;

        int result = lastOccurrence(arr, key, n);
        System.out.println("Last occurrence of " + key + " is at index: " + result);
    }
}
