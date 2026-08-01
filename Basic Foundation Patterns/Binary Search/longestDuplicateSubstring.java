import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class longestDuplicateSubstring {
    private static String s;
    private static int n;
    private static long[] power;
    private static long[] prefix;

    public static String longestDupSubstring(String str) {
        s = str;
        n = s.length();
        long base = 31;

        power = new long[n + 1];
        prefix = new long[n + 1];
        power[0] = 1;

        for (int i = 0; i < n; i++) {
            power[i + 1] = power[i] * base;
            prefix[i + 1] = prefix[i] * base + (s.charAt(i) - 'a' + 1);
        }

        int low = 1;
        int high = n - 1;

        int start = -1;
        int maxLen = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int idx = search(mid);
            if (idx != -1) {
                start = idx;
                maxLen = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private static int search(int len) {
        HashMap<Long, List<Integer>> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {
            long hash = getHash(i, i + len - 1);
            if (map.containsKey(hash)) {

                for (int prev : map.get(hash)) {
                    if (s.substring(prev, prev + len)
                            .equals(s.substring(i, i + len))) {
                        return i;
                    }
                }
            }
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(i);
        }
        return -1;
    }

    private static long getHash(int l, int r) {
        return prefix[r + 1] - prefix[l] * power[r - l + 1];
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(longestDupSubstring(s));
    }
}
