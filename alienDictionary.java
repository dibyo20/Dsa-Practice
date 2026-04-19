import java.util.*;

public class alienDictionary {
    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>(); // To store the graph.
        Map<Character, Integer> indegree = new HashMap<>(); // To store the indegree of each node.

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new ArrayList<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < minLen; j++) { // Store the graph and indegree.
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    found = true;
                    break;
                }

            }
            if (!found && w1.length() > w2.length()) { // If no character is different and w1 is longer than w2, then it's not possible to form a valid order.
                return "";
            }

        }

        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            for (char neighbor : adj.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.length() != indegree.size()) { // If the number of characters in the result is not equal to the number of unique characters in the input, then there is a cycle.
            return "";
        }

        return result.toString();

    }

    public static void main(String[] args) {
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        String order = alienOrder(words);

        if (order.isEmpty()) {
            System.out.println("Invalid dictionary (cycle or prefix issue)");
        } else {
            System.out.println("Alien Dictionary Order: " + order);
        }
    }
}
