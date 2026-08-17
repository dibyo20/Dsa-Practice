public class checkIfAllTheIntegersInARangeAreCovered {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] covered = new int[52];
        for (int[] range : ranges) {
            int start = range[0];
            int end = range[1];
            covered[start]++;
            covered[end + 1]--;
        }
        for (int i = 1; i < covered.length; i++) {
            covered[i] += covered[i - 1];
        }
        for (int i = left; i <= right; i++) {
            if (covered[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 5;
        System.out.println(isCovered(ranges, left, right));
    }
}
