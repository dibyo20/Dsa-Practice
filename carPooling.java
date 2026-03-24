public class carPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            arr[from] += passengers;
            arr[to] -= passengers;
        }
        int currentPassengers = 0;
        for (int i = 0; i < 1001; i++) {
            currentPassengers += arr[i];

            if (currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }
}
