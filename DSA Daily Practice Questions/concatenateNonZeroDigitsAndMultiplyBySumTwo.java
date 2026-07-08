public class concatenateNonZeroDigitsAndMultiplyBySumTwo {
    static final int MOD = 1_000_000_007;

    public static int[] concatenatedDivisibility(String s, int[][] queries) {
        int n = s.length();
        int[] indices = new int[n + 1];
        long[] prefixNum = new long[n + 1];
        int[] prefixSum = new int[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;

        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        int m = 0;
        indices[0] = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch != '0') {
                m++;

                int digit = ch - '0';
                indices[m] = i;
                prefixSum[m] = prefixSum[m - 1] + digit;
                prefixNum[m] = (prefixNum[m - 1] * 10 + digit) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            int left = lowerBound(indices, 1, m, l);
            int right = upperBound(indices, 1, m, r);

            if (left > right) {
                ans[q] = 0;
                continue;
            }

            int sum = prefixSum[right] - prefixSum[left - 1];
            int len = right - left + 1;

            long number = (prefixNum[right]
                    - (prefixNum[left - 1] * pow10[len]) % MOD
                    + MOD) % MOD;

            ans[q] = (int) ((number * sum) % MOD);
        }
        return ans;
    }

    private static int lowerBound(int[] arr, int l, int r, int target) {
        int ans = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    private static int upperBound(int[] arr, int l, int r, int target) {
        int ans = l - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "10203004";
        int[][] queries = { { 0, 7 }, { 1, 3 }, { 4, 6 } };
        int[] ans = concatenatedDivisibility(s, queries);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
