import java.util.*;

public class topKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (map.get(a).equals(map.get(b))) {
                        return a.compareTo(b); // If frequencies are the same, sort alphabetically
                    }
                    return map.get(b) - map.get(a); // Sort by frequency in descending order
                });

        pq.addAll(map.keySet());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        String words[] = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
}
