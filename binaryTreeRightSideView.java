import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class binaryTreeRightSideView {
    public static List<Integer> rightSideViewBFS(TreeNode root) { // This approach uses level order traversal and adds
                                                                  // the last node of each level to the result list.
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return result;
    }

    public static List<Integer> rightSideViewDFS(TreeNode root) { // This basically uses the approach of first visiting
                                                                  // the right child and then the left child, so that we
                                                                  // can add the first node of each level to the result
                                                                  // list.
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null)
            return;

        if (level == result.size()) {
            result.add(node.val);
        }

        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(rightSideViewBFS(root));
        System.out.println(rightSideViewDFS(root));
    }
}
