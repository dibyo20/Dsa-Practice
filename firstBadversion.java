public class firstBadversion {
    static int bad = 4; // This is just a placeholder for the bad version. In a real scenario, this would be provided by the system or API.

    public static boolean isBadVersion(int version) { // This is a mock implementation of the isBadVersion API. In a real scenario, this would be provided by the system or API.
        return version >= bad;
    }

    public static int firstbadversion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid; // If mid is a bad version, then the first bad version must be at mid or before
                           // mid, so we set end to mid.
            } else {
                start = mid + 1; // If mid is not a bad version, then the first bad version must be after mid, so
                                 // we set start to mid + 1.
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstbadversion(n));
    }
}
