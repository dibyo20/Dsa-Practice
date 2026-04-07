import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class maximumWidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currIndex = current.index - minIndex;

                if (i == 0)
                    first = currIndex;
                if (i == size - 1)
                    last = currIndex;

                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, 2 * currIndex + 1));
                }

                if (current.node.right != null) {
                    queue.offer(new Pair(current.node.right, 2 * currIndex + 2));
                }
            }

            int width = last - first + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        int result = widthOfBinaryTree(root);
        System.out.println("Maximum Width: " + result); // Output: 4
    }
}
