import java.util.*;

public class closestNodesQueriesInABinarySearchTree {
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

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }   

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = inorder(root);
        List<List<Integer>> ans = new ArrayList<>();

        for (int query : queries) {
            int left = 0, right = list.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) >= query) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int mini = -1;
            int maxi = -1;

            if (left < list.size()) {
                maxi = list.get(left);
            }

            if (left < list.size() && list.get(left) == query) {
                mini = query;
            } else if (left > 0) {
                mini = list.get(left - 1);
            }

            ans.add(Arrays.asList(mini, maxi));
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);

        List<Integer> queries = Arrays.asList(2, 5, 16);
        List<List<Integer>> ans = closestNodes(root, queries);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
