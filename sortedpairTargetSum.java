import java.util.*;

public class sortedpairTargetSum {     

    public static boolean pairsum(ArrayList<Integer> arr, int target) { // Brute Force Approach, TC: O(n^2), SC: O(1)
        for(int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == target) {
                    System.out.println("Pair found: " + arr.get(i) + ", " + arr.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairsumOptimized(ArrayList<Integer> arr, int target) { // Two Pointer Technique, TC: O(n), SC: O(1)
        int lp = 0;
        int rp = arr.size() - 1;
        while (lp < rp) {
            int sum = arr.get(lp) + arr.get(rp);
            if (sum == target) {
                System.out.println("Pair found: " + arr.get(lp) + ", " + arr.get(rp));
                return true;
            } else if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        int target = 5;
        System.out.println(pairsum(arr, target));  // Using Brute Force Approach
        System.out.println(pairsumOptimized(arr, target));  // Using Two Pointer Technique
    }
}
