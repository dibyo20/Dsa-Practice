public class lastoccurbacktrackrec {
    public static int lastocc(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }
        int isFound = lastocc(arr, i + 1, key);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 3, 6};
        int key = 3;
        int result = lastocc(arr, 0, key);
        System.out.println("Last occurrence of " + key + " is at index: " + result);
    }
}
