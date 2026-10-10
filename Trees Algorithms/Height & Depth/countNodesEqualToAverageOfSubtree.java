public class countNodesEqualToAverageOfSubtree {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Result{
        int sum;
        int count;

        Result(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }

    public static int ans = 0;

    public static int averageOfSubtree(TreeNode root){
        dfs(root);
        return ans;
    }

    public static Result dfs(TreeNode root){
        if(root == null){
            return new Result(0, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        int sum = left.sum + right.sum + root.data;
        int count = left.count + right.count + 1;

        if(sum / count == root.data){
            ans++;
        }

        return new Result(sum, count);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);

        System.out.println(averageOfSubtree(root));
    }
}
