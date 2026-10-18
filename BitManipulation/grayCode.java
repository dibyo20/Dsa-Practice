import java.util.*;

public class grayCode {
    public static List<Integer> code(int n) {
        List<Integer> ans = new ArrayList<>();
        int total = 1 << n;

        for(int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1); // ">>1" means right shift by 1 bit
            ans.add(gray);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(code(2));
    }
}
