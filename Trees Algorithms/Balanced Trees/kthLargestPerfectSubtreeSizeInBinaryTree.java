import java.util.*;

public class kthLargestPerfectSubtreeSizeInBinaryTree {
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

    public static class TreeInfo {
        boolean isPerfect;
        int size;
        int height;

        TreeInfo(boolean isPerfect, int size, int height) {
            this.isPerfect = isPerfect;
            this.size = size;
            this.height = height;
        }
    }

    public static int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dfs(root, pq, k);

        if (pq.size() < k) {
            return -1;
        }

        return pq.peek();
    }

    public static TreeInfo dfs(TreeNode root, PriorityQueue<Integer> pq, int k) {
        if (root == null) {
            return new TreeInfo(true, 0, 0);
        }

        TreeInfo left = dfs(root.left, pq, k);
        TreeInfo right = dfs(root.right, pq, k);

        if (left.isPerfect && right.isPerfect && left.height == right.height) {
            int size = left.size + right.size + 1;
            int height = left.height + 1;
            pq.add(size);
            if (pq.size() > k) {
                pq.poll();
            }

            return new TreeInfo(true, size, height);
        }

        return new TreeInfo(false, left.size + right.size + 1, Math.max(left.height, right.height) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(9);

        System.out.println(kthLargestPerfectSubtree(root, 2));
    }
}
