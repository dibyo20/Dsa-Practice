import java.util.HashMap;

public class wordPattern {
    public static boolean isPattern(String pattern, String s) {
        String[] word = s.split(" ");

        if (pattern.length() != word.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = word[i];

            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(w)) {
                    return false;
                }
            }

            if (map2.containsKey(w)) {
                if (map2.get(w) != c) {
                    return false;
                }
            }

            map1.put(c, w);
            map2.put(w, c);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(isPattern(pattern, s));
    }
}
