public class reverseWordsInAStringThree {
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int start = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                for (int j = i - 1; j >= start; j--) {
                    ans.append(s.charAt(j));
                }
                if (i != s.length()) {
                    ans.append(' ');
                }
                start = i + 1;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
