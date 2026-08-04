import java.util.PriorityQueue;
public class reorganizeString {
    public static class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public static String reorganize(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int n = s.length();
        for (int f : freq) {
            if (f > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(new Pair((char) (i + 'a'), freq[i]));
            }
        }

        StringBuilder ans = new StringBuilder();
        Pair prev = null;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            ans.append(curr.c);
            curr.freq--;

            if (prev != null && prev.freq > 0) {
                pq.add(prev);
            }
            prev = curr;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganize("aab"));
        System.out.println(reorganize("aaab"));
    }
}
