import java.util.Arrays;

public class platesBetweenCandles {
    public static int[] platesBtwCandles(String s, int[][] queries) {
        int[] prefixPlates = new int[s.length()];
        int[] leftCandle = new int[s.length()];
        int[] rightCandle = new int[s.length()];
        int plates = 0;
        int left = -1;
        int right = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                plates++;
                prefixPlates[i] = plates;
            } else {
                prefixPlates[i] = plates;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                left = i;
            }
            leftCandle[i] = left;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                right = i;
            }
            rightCandle[i] = right;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int firstCandle = rightCandle[queries[i][0]];
            int lastCandle = leftCandle[queries[i][1]];
            if (firstCandle == -1 || lastCandle == -1 || firstCandle >= lastCandle) {
                ans[i] = 0;
            } else {
                ans[i] = prefixPlates[lastCandle] - prefixPlates[firstCandle];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] queries = { { 2, 5 }, { 5, 9 } };
        String s = "**|**|***|";
        System.out.println(Arrays.toString(platesBtwCandles(s, queries)));
    }
}
