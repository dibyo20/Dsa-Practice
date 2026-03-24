import java.util.*;

public class stackusingJCF {
    public static void main(String args[]) {
        Stack<Integer> Stack = new Stack<>();
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);

        while (!Stack.isEmpty()) {
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}
