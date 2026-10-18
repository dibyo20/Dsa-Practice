public class stepByStepDirectionsFromABinaryTreeNodeToAnother {
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

    public static String getDirectionsApproachOne(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        StringBuilder result = new StringBuilder();
        for (int j = i; j < startPath.length(); j++) {
            result.append('U');
        }

        result.append(destPath.substring(i));

        return result.toString();
    }

    public static String getDirectionsApproachTwo(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(lca, startValue, startPath);
        findPath(lca, destValue, destPath);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < startPath.length(); i++) {
            result.append('U');
        }
        result.append(destPath);

        return result.toString();
    }

    private static TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }

        if (root.val == startValue || root.val == destValue) {
            return root;
        }

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private static boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        path.append("L");
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(getDirectionsApproachOne(root, 3, 6));
        System.out.println(getDirectionsApproachTwo(root, 3, 6));
    }
}
