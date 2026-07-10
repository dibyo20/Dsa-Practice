public class convertSortedListToBinarySearchTree {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static ListNode current;

    public static TreeNode sortedListToBST(ListNode head) {
        current = head;
        int size = getSize(head);
        return buildTree(0, size - 1);
    }

    private static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private static TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode leftChild = buildTree(left, mid - 1);

        TreeNode root = new TreeNode(current.val);

        root.left = leftChild;
        current = current.next;
        root.right = buildTree(mid + 1, right);
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
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = sortedListToBST(head);
        inorder(root);
    }

}
