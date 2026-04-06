import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class serializeAndDeserializeBinaryTree {
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }

    private static void helperSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        helperSerialize(root.left, sb);
        helperSerialize(root.right, sb);
    }

    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return helperDeserialize(q);
    }

    private static TreeNode helperDeserialize(Queue<String> q) {
        String val = q.poll();

        if (val.equals("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helperDeserialize(q);
        node.right = helperDeserialize(q);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = deserialize(serialized);
        System.out.println("Deserialized Root Value: " + deserializedRoot.val);
    }
}
