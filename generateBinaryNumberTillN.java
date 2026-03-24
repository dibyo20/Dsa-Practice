import java.util.LinkedList;
import java.util.Queue;

public class generateBinaryNumberTillN {

    public static void generateBinary(int N) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 1; i <= N; i++) {
            String curr = q.poll(); // Here we using 'poll()' instead of 'remove()', because it will not throw error if queue is empty.
            System.out.print(curr + " ");

            q.add(curr + "0");
            q.add(curr + "1");
        }
    }

    public static void main(String[] args) {
        int N = 4;
        generateBinary(N);
    }
}
