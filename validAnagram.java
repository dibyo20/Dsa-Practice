import java.util.*;

public class validAnagram {
    public static boolean isAnagram(String s, String t) {  // TC: O(n), SC: O(n)
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) != null) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        boolean result = isAnagram(s, t);
        System.out.println("Are the strings \"" + s + "\" and \"" + t + "\" anagrams? " + result);
    }
}

// Note: In this we map the first string's characters and their counts in a hashmap. Then we iterate through the second string,
// reducing the counts in the hashmap. If we find a character in the second string that is not in the hashmap or if we try to reduce a count below zero,
// we return false. If we successfully process all characters, i.e. haspmap is empty at the end, we return true.
