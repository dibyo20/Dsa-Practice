import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // First element always 1
            row.add(1);

            // Middle elements
            for (int j = 1; j < i; j++) {
                List<Integer> prev = result.get(i - 1);
                row.add(prev.get(j - 1) + prev.get(j));
            }

            // Last element (only if row size > 1)
            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
