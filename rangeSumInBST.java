import java.util.Stack;

public class rangeSumInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int rangeSumBST1(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (curr.val > R)
                break;

            if (curr.val >= L) {
                sum += curr.val;
            }

            curr = curr.right;
        }

        return sum;
    }

    public static int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        if (root.val < L)
            return rangeSumBST2(root.right, L, R);

        if (root.val > R)
            return rangeSumBST2(root.left, L, R);

        return root.val
                + rangeSumBST2(root.left, L, R)
                + rangeSumBST2(root.right, L, R);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        System.out.println(rangeSumBST1(root, 5, 11));
        System.out.println(rangeSumBST2(root, 5, 11));
    }

}
