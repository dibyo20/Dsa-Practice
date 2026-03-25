public class medianOfTwoSortedArray {
    public static double findMedian(int nums1[], int nums2[]) {
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1; // This formula ensures that the left half of the combined
                                                           // array has one more element than the right half when the
                                                           // total number of elements is odd, and an equal number of
                                                           // elements when it's even.

            int maxleft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxleft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxleft1 <= minRight2 && maxleft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxleft1, maxleft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return (Math.max(maxleft1, maxleft2));
                }
            } else if (maxleft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        throw new IllegalArgumentException(); // This line is written if the input arrays are not valid (e.g., not
                                              // sorted or of incorrect sizes) and in place of this we can also return
                                              // -1 or any other value to indicate an error, but throwing an exception
                                              // is a common way to handle such cases in Java.
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3 };
        int nums2[] = { 2 };
        System.out.println(findMedian(nums1, nums2));
    }
}
