import java.util.*;

public class removeDuplicateLetters {
    public static String removeDuplicate(String s) {
        int freq[] = new int[26];
        ;
        int isVisited[] = new int[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']--;
            if (isVisited[s.charAt(i) - 'a'] == 1) {
                continue;
            }
            while (!st.isEmpty() && st.peek() > s.charAt(i) && freq[st.peek() - 'a'] > 0) {
                isVisited[st.peek() - 'a'] = 0;
                st.pop();
            }
            st.push(s.charAt(i));
            isVisited[s.charAt(i) - 'a'] = 1;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate("bcabc"));
    }
}
