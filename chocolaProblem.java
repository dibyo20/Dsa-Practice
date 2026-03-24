import java.util.*;

public class chocolaProblem {
    public static void main(String args[]) {
        // n = 4, m = 6
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { // Horizontal Cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // Vertical Cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) { // If vertical size is less than horizontal, then extra horizontal array elements                     
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) { // If horizontal size is less than vertical, then extra vertical array elements
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("min cost of cuts = " + cost);
    }
}
