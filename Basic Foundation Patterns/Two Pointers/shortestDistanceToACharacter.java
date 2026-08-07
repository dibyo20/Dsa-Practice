public class shortestDistanceToACharacter {
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int lastSeen = -n;
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                lastSeen = i;
            }
            ans[i] = i - lastSeen;
        }

        lastSeen = 2 * n;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                lastSeen = i;
            }
            ans[i] = Math.min(ans[i], lastSeen - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] ans = shortestToChar(s, c);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
