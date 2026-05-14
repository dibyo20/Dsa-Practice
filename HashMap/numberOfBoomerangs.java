import java.util.HashMap;

public class numberOfBoomerangs {
    public static int numOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d1 = points[i][0] - points[j][0];
                int d2 = points[i][1] - points[j][1];
                int dist = d1 * d1 + d2 * d2;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int val : map.values()) {
                res += val * (val - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int points[][] = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println(numOfBoomerangs(points));
    }
}
