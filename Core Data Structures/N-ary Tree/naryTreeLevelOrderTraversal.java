import java.util.*;

public class naryTreeLevelOrderTraversal {
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

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            result.add(level);
        }
        return result;
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

        System.out.println(levelOrder(root));
    }
}
