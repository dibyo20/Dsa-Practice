public class duplicateZeros {
    public static void duplicateZero(int[] arr) {
        int n = arr.length;
        int countZeros = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZeros++;
            }
        }
        int i = n - 1;
        int j = n - 1 + countZeros;

        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
        duplicateZero(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
