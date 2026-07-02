import java.util.ArrayList;
import java.util.List;

public class pascalsTriangleTwo {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long value = 1;

        for (int i = 0; i <= rowIndex; i++) {
            ans.add((int) value);
            value = value * (rowIndex - i) / (i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(0));
        System.out.println(getRow(1));
    }
}
