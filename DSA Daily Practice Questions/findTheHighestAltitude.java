public class findTheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;
        for (int g : gain) {
            highest += g;
            altitude = Math.max(altitude, highest);
        }
        return altitude;
    }

    public static void main(String[] args) {
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(largestAltitude(gain));
    }
}
