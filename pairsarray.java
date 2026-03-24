public class pairsarray {
    public static void pairsArray(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
                count++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs: " + count);
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        pairsArray(arr);
    }
    
}
