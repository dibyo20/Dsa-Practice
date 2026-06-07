import java.util.*;

public class createBinaryTreeFromDescriptions {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }

            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for (int desc[] : descriptions) {
            int parent = desc[0];
            if (!children.contains(parent)) {
                return map.get(parent);
            }
        }

        return null;
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
        TreeNode root = createBinaryTree(descriptions);
        preorder(root);
    }
}
