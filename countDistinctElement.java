import java.util.*;

public class countDistinctElement {
    public static void main(String[] args) {
        HashSet<Integer> distinctElements = new HashSet<>();
        int[] numbers = { 1, 2, 3, 2, 4, 5, 1, 6, 3 };

        for (int i = 0; i < numbers.length; i++) {
            distinctElements.add(numbers[i]);
        }

        System.out.println("Distinct elements: " + distinctElements);
        System.out.println("Count of distinct elements: " + distinctElements.size());
    }
}
