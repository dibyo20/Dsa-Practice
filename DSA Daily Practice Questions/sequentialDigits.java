import java.util.*;

public class sequentialDigits {
    public static List<Integer> seqDigits(int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int len = lowLen; len <= highLen; len++) {

            int num = 0;
            for (int digit = 1; digit <= len; digit++) {
                num = num * 10 + digit;
            }

            int step = 0;
            for (int i = 0; i < len; i++) {
                step = step * 10 + 1;
            }

            for (int i = 0; i < 10 - len; i++) {
                if (num > high) {
                    break;
                }

                if (num >= low && num <= high) {
                    ans.add(num);
                }

                num += step;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(seqDigits(100, 300));
    }
}
