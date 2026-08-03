import java.util.*;

public class wordBreak {
    public static boolean isWords(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return solve(0, s, dict, memo);
    }

    private static boolean solve(int start, String s, HashSet<String> dict, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);

            if (dict.contains(prefix) && solve(end, s, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "code");
        String s = "leetcode";
        System.out.println(isWords(s, wordDict));
    }
}
