public class maximumProductOfTwoElementsInAnArray {
    public static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max2 = num;
            }

            if (num <= min1) {
                min1 = num;
            }
        }

        int prod1 = (max1 - 1) * (max2 - 1);
        int prod2 = (min1 - 1) * (max1 - 1);

        return Math.max(prod1, prod2);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        System.out.println(maxProduct(nums));
    }
}
