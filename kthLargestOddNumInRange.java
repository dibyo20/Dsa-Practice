import java.util.*;

public class kthLargestOddNumInRange {
    public static void main(String[] args) {
        int l = -3;
        int r = 3;
        int k = 1;

        ArrayList<Integer> oddNums = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (i % 2 != 0) {
                oddNums.add(i);
            }
        }

        if (k > oddNums.size()) { // If k is greater than total odd numbers.
            System.out.println(0);
            return;
        }

        Collections.sort(oddNums, Collections.reverseOrder()); // Sorting in descending order.
        System.out.println(oddNums.get(k - 1));
    }
}
