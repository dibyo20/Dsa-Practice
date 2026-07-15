public class longestValidParentheses {
    public static int longestValidP(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                ans = Math.max(ans, 2 * left);
            }

            if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                ans = Math.max(ans, 2 * left);
            }

            if (left > right) {
                left = right = 0;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        System.out.println(longestValidP(")()())"));
    }
}
