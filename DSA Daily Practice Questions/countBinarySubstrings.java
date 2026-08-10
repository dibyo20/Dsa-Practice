public class countBinarySubstrings {
    public static int countBinary(String s) {
        if (s.length() == 0)
            return 0;
        int ans = 0;
        int curr = 1;
        int prev = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        ans += Math.min(curr, prev);
        return ans;
    }

    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinary(s));
    }
}
