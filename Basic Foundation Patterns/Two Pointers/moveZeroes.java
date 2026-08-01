import java.util.*;

public class moveZeroes {
    public static void move(int nums[]) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        move(nums);
        System.out.println(Arrays.toString(nums));
    }
}
