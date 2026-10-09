public class smallestStringStartingFromLeaf {
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

    public static String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        String smallest = "";
        return dfs(root, sb, smallest);
    }

    public static String dfs(TreeNode root, StringBuilder curr, String smallest) {
        if (root == null) {
            return smallest;
        }
        curr.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            String currStr = curr.reverse().toString();
            curr.reverse();
            if (smallest.equals("") || currStr.compareTo(smallest) < 0) {
                smallest = currStr;
            }
        }
        smallest = dfs(root.left, curr, smallest);
        smallest = dfs(root.right, curr, smallest);
        curr.deleteCharAt(curr.length() - 1);
        return smallest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(smallestFromLeaf(root));
    }
}
