import java.util.*;

public class longestWordInDictionary {
    public static String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        HashSet<String> set = new HashSet<>();
        String ans = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > ans.length()) {
                    ans = word;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(longestWord(words));
    }
}
