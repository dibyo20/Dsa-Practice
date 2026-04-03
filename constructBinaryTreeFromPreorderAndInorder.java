import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class constructBinaryTreeFromPreorderAndInorder {
    static int preIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        int rootVal = preorder[preIndex++]; // It takes the current root value from preorder and increments the index for the next call
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);
        root.left = construct(preorder, left, index - 1);
        root.right = construct(preorder, index + 1, right);
        return root;
    }

    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(preorder, inorder);
        printInorder(root);
    }
}
