import java.util.*;

public class balanceABinarySearchTree {
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

    public static List<Integer> list = new ArrayList<>();

    public static TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return constructBST(0, list.size() - 1);
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static TreeNode constructBST(int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = constructBST(left, mid - 1);
        root.right = constructBST(mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        
        TreeNode ans = balanceBST(root);
        System.out.println(ans.val);
    }
}
