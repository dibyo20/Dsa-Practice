import java.util.*;

public class naryTreePostorderTraversal {
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

    public static List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        dfs(root, ans);
        return ans;
    }

    private static void dfs(Node root, List<Integer> ans) {
        if (root == null)
            return;

        for (Node child : root.children) {
            dfs(child, ans);
        }
        ans.add(root.val);
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
        System.out.println(postorder(root));
    }
}
