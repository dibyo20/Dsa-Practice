import java.util.*;

public class diStringMatch {
    public static int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int left = 0;
        int right = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = left++;
            } else {
                ans[i] = right--;
            }
        }
        ans[n] = left;
        return ans;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] ans = diStringMatch(s);
        System.out.println(Arrays.toString(ans));
    }
}