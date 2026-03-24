import java.util.*;

public class buildTreePreorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) { // TC: O(1)
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) { // TC: O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) { // TC: O(n)
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) { // TC: O(n)
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int heightofTree(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = heightofTree(root.left);
        int rh = heightofTree(root.right);

        return (Math.max(lh, rh) + 1);
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int lc = countOfNodes(root.left);
        int rc = countOfNodes(root.right);

        return (lc + rc + 1);
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int sl = sumOfNodes(root.left);
        int sr = sumOfNodes(root.right);

        return (sl + sr + root.data);
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // buildTreePreorder.preOrder(root);
        // buildTreePreorder.inOrder(root);
        // buildTreePreorder.postOrder(root);

        // buildTreePreorder.levelOrder(root);

        System.out.println("Height of tree is : " + buildTreePreorder.heightofTree(root));
        System.out.println("Count of Nodes is : " + buildTreePreorder.countOfNodes(root));
        System.out.println("Sum of Nodes is : " + buildTreePreorder.sumOfNodes(root));
    }
}
