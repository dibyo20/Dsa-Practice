public class plusOne {
    public static int[] plusone(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits = { 9, 9, 9 };

        int[] result = plusone(digits);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}