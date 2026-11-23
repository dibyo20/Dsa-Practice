import java.util.*;

public class accountsMerge {
    public static int[] parent;
    public static int[] size;

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return;
        }

        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    public static List<List<String>> merge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<String, Integer> emailToAccount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    int previousIndex = emailToAccount.get(email);
                    union(i, previousIndex);
                }
            }
        }

        Map<Integer, TreeSet<String>> mergedEmails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            mergedEmails.putIfAbsent(root, new TreeSet<>());

            for (int j = 1; j < accounts.get(i).size(); j++) {
                mergedEmails.get(root).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (int root : mergedEmails.keySet()) {
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0));

            mergedAccount.addAll(mergedEmails.get(root));
            result.add(mergedAccount);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> result = merge(accounts);

        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}
