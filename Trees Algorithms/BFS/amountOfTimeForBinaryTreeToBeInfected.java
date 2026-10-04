import java.util.*;

public class amountOfTimeForBinaryTreeToBeInfected {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void buildGraph(TreeNode root, ArrayList<ArrayList<Integer>> graph) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
            buildGraph(root.left, graph);
        }

        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
            buildGraph(root.right, graph);
        }
    }

    public static int amountOfTime(TreeNode root, int start) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            graph.add(new ArrayList<>());
        }
        buildGraph(root, graph);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(start);
        visited[start] = true;
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int next : graph.get(curr)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            time++;
        }
        return time - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        System.out.println(amountOfTime(root, 3));
    }
}
