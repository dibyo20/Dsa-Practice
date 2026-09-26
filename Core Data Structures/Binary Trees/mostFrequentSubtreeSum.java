import java.util.*;

public class mostFrequentSubtreeSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static Map<Integer, Integer> freqMap = new HashMap<>();
    public static int maxFreq = 0;

    public static int[] mostFrequent(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + dfs(root.left) + dfs(root.right);
        int freq = freqMap.getOrDefault(sum, 0) + 1;
        freqMap.put(sum, freq);
        maxFreq = Math.max(maxFreq, freq);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        
        System.out.println(Arrays.toString(mostFrequent(root)));
    }
}
