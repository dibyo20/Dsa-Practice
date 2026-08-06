import java.util.*;

public class theSkylineProblem {
    public static class Point {
        int x;
        int h;

        public Point(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        for (int[] building : buildings) {
            points.add(new Point(building[0], -building[2]));
            points.add(new Point(building[1], building[2]));
        }

        Collections.sort(points, (a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            }
            return a.h - b.h;
        });

        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1);
        int prevMax = 0;

        for (Point p : points) {
            if (p.h < 0) {
                int height = -p.h;
                heights.put(height, heights.getOrDefault(height, 0) + 1);
            } else {
                int freq = heights.get(p.h);
                if (freq == 1) {
                    heights.remove(p.h);
                } else {
                    heights.put(p.h, freq - 1);
                }
            }

            int currMax = heights.lastKey();
            if (currMax != prevMax) {
                ans.add(Arrays.asList(p.x, currMax));
                prevMax = currMax;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
        List<List<Integer>> ans = getSkyline(buildings);
        System.out.println(ans);
    }
}
