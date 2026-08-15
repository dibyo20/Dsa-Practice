public class minimumTimeToRepairCars {
    public static long repairCars(int[] ranks, int cars) {
        int minrank = Integer.MAX_VALUE;
        for (int rank : ranks) {
            minrank = Math.min(minrank, rank);
        }

        long low = 0;
        long high = (long) minrank * cars * cars;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canComplete(ranks, cars, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canComplete(int[] ranks, int cars, long time) {
        long count = 0;
        for (int rank : ranks) {
            count += (long) Math.sqrt(time / rank);
            if (count >= cars) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int ranks[] = { 4, 2, 3, 1 };
        int cars = 10;
        System.out.println(repairCars(ranks, cars));
    }
}
