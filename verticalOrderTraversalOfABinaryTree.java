import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class NodeInfo {
    TreeNode node;
    int row, col;

    NodeInfo(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class verticalOrderTraversalOfABinaryTree {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo curr = queue.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.putIfAbsent(col, new TreeMap<>()); // This ensures that columns are sorted
            map.get(col).putIfAbsent(row, new PriorityQueue<>()); // This ensures that rows are sorted and values in the
                                                                  // same row and column are stored in a min-heap
                                                                  // (priority queue) to maintain sorted order
            map.get(col).get(row).offer(node.val); // This adds the node value to the priority queue for the
                                                   // corresponding row and column

            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) { // This iterates over columns in sorted
                                                                             // order
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) { // This iterates over rows in sorted order
                while (!pq.isEmpty()) { // This ensures that values are added in sorted order if they are in the same
                                        // row and column
                    list.add(pq.poll());
                }
            }

            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);

        System.out.println(result); // Expected: [[9], [3,15], [20], [7]]
    }
}
