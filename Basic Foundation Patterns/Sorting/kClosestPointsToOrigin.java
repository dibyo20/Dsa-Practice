import java.util.*;

public class kClosestPointsToOrigin {
    public static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);

        for (int[] point : points) {
            if (pq.size() < k) {
                pq.add(new Point(point[0], point[1]));
            } else {
                if (pq.peek().distance > new Point(point[0], point[1]).distance) {
                    pq.poll();
                    pq.add(new Point(point[0], point[1]));
                }
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        int[][] result = kClosest(points, k);
        for (int[] point : result) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}



