import java.util.*;

public class letterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        backtrack(0, digits, map, new StringBuilder(), ans);
        return ans;
    }

    public static void backtrack(int index, String digits, String[] map, StringBuilder current, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(index + 1, digits, map, current, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
