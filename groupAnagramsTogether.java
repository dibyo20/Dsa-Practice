import java.util.*;

public class groupAnagramsTogether {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append(count).append('#');
            }
            String key = keyBuilder.toString();

            // if (!map.containsKey(key)) {
            // map.put(key, new ArrayList<>());
            // }
            // map.get(key).add(word);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word); // This is the sort way to do the above four
                                                                        // lines.

        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs1));

        String[] strs2 = { "" };
        System.out.println(groupAnagrams(strs2));

        String[] strs3 = { "a" };
        System.out.println(groupAnagrams(strs3));
    }
}
