import java.util.*;

public class validateBinaryTreeNodes {
    public static boolean validateTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        if (root == -1) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(root);
        visited[root] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            int left = leftChild[node];
            int right = rightChild[node];

            if (left != -1) {
                if (visited[left]) {
                    return false;
                }
                visited[left] = true;
                q.add(left);
            }

            if (right != -1) {
                if (visited[right]) {
                    return false;
                }
                visited[right] = true;
                q.add(right);
            }
        }
        return count == n;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = { 1, -1, 3, -1 };
        int[] rightChild = { 2, -1, -1, -1 };
        System.out.println(validateTreeNodes(n, leftChild, rightChild));
    }
}
