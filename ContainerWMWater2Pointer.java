import java.util.ArrayList;

public class ContainerWMWater2Pointer {
    public static int storeWater(ArrayList<Integer> heights) { // TC: O(n), SC: O(1)
        int maxWater = 0;
        int lp = 0, rp = heights.size() - 1;
        while (lp < rp) {
            int height = Math.min(heights.get(lp), heights.get(rp));
            int width = rp - lp;
            int water = height * width;
            maxWater = Math.max(maxWater, water);

            // Moving the pointer pointing to the shorter line
            if (heights.get(lp) < heights.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String args[]) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);
        System.out.println("Maximum water that can be stored: " + storeWater(heights));
    }
}
