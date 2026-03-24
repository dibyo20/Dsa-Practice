import java.util.*;

public class sortedandroatedpairTargetSum {
    public static boolean pairSum2(ArrayList<Integer> list, int target) { // TC: O(n), SC: O(1)
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int lp = bp + 1;
        int rp = bp;
        int n = list.size();
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                System.out.println("Pair found: " + list.get(lp) + " and " + list.get(rp));
                return true;
            } else if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (rp - 1 + n) % n;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum2(list, target));
    }
}
