public class deleteNodeInABST {
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

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) 
            return null;

        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }

            TreeNode successor = root.right;
            while(successor.left != null) {
                successor = successor.left;
            }
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root = deleteNode(root, 3);
        System.out.println(root.val);
    }
}
