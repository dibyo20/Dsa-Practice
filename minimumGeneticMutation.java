import java.util.*;

public class minimumGeneticMutation {
    public static int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene))
            return -1;

        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        char[] genes = { 'A', 'C', 'G', 'T' };
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(endGene))
                    return steps;

                char[] arr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char old = arr[j];

                    for (char ch : genes) {
                        arr[j] = ch;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
        System.out.println(minMutation(startGene, endGene, bank));
    }
}
