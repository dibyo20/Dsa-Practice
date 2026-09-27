import java.util.*;

public class maximumDepthOfNaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int maxDepth(Node root) {
        return dfs(root);
    }

    private static int dfs(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;

        for (Node child : root.children) {
            max = Math.max(max, dfs(child));
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node child1 = new Node(3);
        Node child2 = new Node(2);
        Node child3 = new Node(4);
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        child1.children.add(new Node(5));
        child1.children.add(new Node(6));
        System.out.println(maxDepth(root));
    }
}
