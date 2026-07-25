public class multiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                int prod = digit1 * digit2 + result[i + j + 1];
                result[i + j + 1] = prod % 10;
                result[i + j] += prod / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            if (!(sb.length() == 0 && val == 0)) {
                sb.append(val);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("12", "12"));
    }
}
