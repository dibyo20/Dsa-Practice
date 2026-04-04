import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class constructBinaryTreeFromInorderAndPostorder {
    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.right = construct(inorder, postorder, index + 1, inEnd);
        root.left = construct(inorder, postorder, inStart, index - 1);

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
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(inorder, postorder);
        printInorder(root);
    }
}
