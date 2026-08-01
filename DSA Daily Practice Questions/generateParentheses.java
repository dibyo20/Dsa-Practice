import java.util.*;

public class generateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisHelper(ans, "", n, n);
        return ans;
    }

    public static void generateParenthesisHelper(List<String> ans, String curr, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(curr);
            return;
        }

        if (open > 0) {
            generateParenthesisHelper(ans, curr + "(", open - 1, close);
        }

        if (close > open) {
            generateParenthesisHelper(ans, curr + ")", open, close - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        System.out.println(ans);
    }
}
