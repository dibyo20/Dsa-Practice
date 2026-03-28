public class minimumSpeedtoArriveonTime {
    public static int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int) 1e7;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, hour, mid)) {
                answer = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1; // need more speed
            }
        }
        return answer;
    }

    private static boolean canReach(int[] dist, double hour, int speed) {
        double time = 0.0;

        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / speed;

            if (i != dist.length - 1) {
                time += Math.ceil(t); // wait for next integer hour
            } else {
                time += t; // last train (no wait)
            }

            if (time > hour)
                return false;
        }

        return time <= hour;
    }

    public static void main(String[] args) {
        int[] dist1 = { 1, 3, 2 };
        double hour1 = 6;
        System.out.println(minSpeedOnTime(dist1, hour1));

        int[] dist2 = { 1, 3, 2 };
        double hour2 = 2.7;
        System.out.println(minSpeedOnTime(dist2, hour2));
    }
}
