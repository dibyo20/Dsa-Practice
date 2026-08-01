import java.util.*;

public class topKFrequentWords {
    public static List<String> topK(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b);
            }
            return map.get(b) - map.get(a);
        });

        pq.addAll(map.keySet());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String words[] = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println(topK(words, k));
    }
}
