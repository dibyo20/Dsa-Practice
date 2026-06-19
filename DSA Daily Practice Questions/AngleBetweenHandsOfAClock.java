public class angleBetweenHandsOfAClock {
    public static double angleClock(int hour, int minutes) {
        double min_angle = minutes * 6.0;
        double hour_angle = (hour % 12) * 30.0 + minutes * 0.5;
        double angle = Math.abs(hour_angle - min_angle);
        return Math.min(angle, 360 - angle);
    }

    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
    }
}
