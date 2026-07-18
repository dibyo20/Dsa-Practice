public class findGreatestCommonDivisorOfArray {
    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        while (max != 0) {
            int temp = max;
            max = min % max;
            min = temp;
        }
        return min;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 5, 6, 9, 10 };
        System.out.println(findGCD(nums));
    }
}
