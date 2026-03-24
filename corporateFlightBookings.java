import java.util.Arrays;

public class corporateFlightBookings {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int seats = booking[2];
            arr[first] += seats;
            if (last + 1 < n) {
                arr[last + 1] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }
}
