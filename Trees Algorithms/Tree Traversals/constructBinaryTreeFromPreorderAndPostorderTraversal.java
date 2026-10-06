public class constructBinaryTreeFromPreorderAndPostorderTraversal {
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


    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int index = postStart;
        while (preorder[preStart + 1] != postorder[index]) {
            index++;
        }

        int leftSize = index - postStart + 1;

        root.left = buildTree(preorder, postorder, preStart + 1, preStart + leftSize, postStart, index);
        root.right = buildTree(preorder, postorder, preStart + leftSize + 1, preEnd, index + 1, postEnd - 1);

        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = constructFromPrePost(preorder, postorder);
        inorder(root);
    }
}
