public class checkIfArrayPairsAreDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for (int num : arr) {
            count[(num % k + k) % k]++;
        }

        if (count[0] % 2 != 0) {
            return false;
        }

        if (k % 2 == 0 && count[k / 2] % 2 != 0) {
            return false;
        }

        for (int i = 1; i < (k + 1) / 2; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { -10, 10 }, k = 2;
        System.out.println(canArrange(arr, k));
    }
}
