import java.util.*;

public class describeThePainting {
    public static List<List<Long>> describePainting(int[][] segments) {
        List<List<Long>> ans = new ArrayList<>();
        long[] diff = new long[100001];
        boolean[] isBoundary = new boolean[100001];

        for (int[] seg : segments) {
            diff[seg[0]] += seg[2];
            diff[seg[1]] -= seg[2];
            isBoundary[seg[0]] = true;
            isBoundary[seg[1]] = true;
        }

        long currSum = 0;
        int start = 0;

        for (int i = 0; i < diff.length; i++) {
            if (isBoundary[i] && i != start) {
                if (currSum != 0) {
                    ans.add(Arrays.asList((long) start, (long) i, currSum));
                }
                start = i;
            }
            currSum += diff[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] segments = { { 1, 4, 5 }, { 4, 7, 7 }, { 1, 7, 9 } };
        System.out.println(describePainting(segments));
    }
}
