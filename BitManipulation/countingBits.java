import java.util.Arrays;

public class countingBits {
    public static int[] countBits(int n) {
        int ans[] = new int[n + 1];

        for(int i = 1; i<=n; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }
}
