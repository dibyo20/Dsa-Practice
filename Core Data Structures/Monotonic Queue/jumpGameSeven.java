public class jumpGameSeven {
    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reachableCount = 0;

        for (int i = minJump; i < n; i++) {
            int add = i - minJump;
            if (dp[add]) {
                reachableCount++;
            }

            int remove = i - maxJump - 1;
            if (remove >= 0 && dp[remove]) {
                reachableCount--;
            }

            if (reachableCount > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(canReach("011010", 2, 3));
    }
}
