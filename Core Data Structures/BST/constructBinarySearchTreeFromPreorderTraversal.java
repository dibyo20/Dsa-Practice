public class constructBinarySearchTreeFromPreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    static int index = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    public static TreeNode build(int[] preorder, int upperBound) {
        if(index == preorder.length){
            return null;
        }

        if(preorder[index] > upperBound){
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, root.val);
        root.right = build(preorder, upperBound);
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        printTree(root);
    }
}
