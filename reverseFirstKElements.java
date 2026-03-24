import java.util.*;
public class reverseFirstKElements {

    public static void reverseK(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size())
            return;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        int k = 5;
        reverseK(q, k);
        System.out.println(q);
    }
}
