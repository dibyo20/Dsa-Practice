import java.util.ArrayList;

public class partitionArrayAccordingToGivenPivot {
    public static int[] partitionArray(int[] nums, int pivot) {
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                smaller.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        int[] ans = new int[nums.length];
        int index = 0;
        for (int num : smaller) {
            ans[index++] = num;
        }
        for (int num : equal) {
            ans[index++] = num;
        }
        for (int num : greater) {
            ans[index++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 5;
        int[] ans = partitionArray(nums, pivot);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
