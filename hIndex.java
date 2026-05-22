import java.util.Arrays;

public class hIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;
            if (citations[mid] >= papers) {
                ans = papers;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 3, 1}));
    }
}
