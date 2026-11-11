public class validMountainArray {
    public static boolean validMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        int i = 0;
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
                i++;
            } else {
                break;
            }
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                i++;
            } else {
                return false;
            }
        }

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 2, 1 };
        System.out.println(validMountain(arr));
    }
}
