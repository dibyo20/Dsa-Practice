public class firstBadVersion {
    public static int firstBad(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static boolean isBadVersion(int version) {
        // This is a placeholder for the actual implementation.
        // In a real scenario, this would be provided by the system.
        return version >= 4; // Example: versions 4 and above are bad.
    }

    public static void main(String[] args) {
        int n = 10;
        int badVersion = firstBad(n);
        System.out.println("The first bad version is: " + badVersion);
    }
}
