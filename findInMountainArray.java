class MountainArray { // Simulating the MountainArray interface
    private int[] arr;
    private int calls = 0;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        calls++;
        return arr[index];
    }

    public int length() {
        return arr.length;
    }

    public int getCalls() {
        return calls;
    }
}

public class findInMountainArray { 
    public static int findInMountain(int target, MountainArray mountainArr) { 
        int peak = findPeak(mountainArr); // First find the peak of the mountain array

        int left = binarySearch(mountainArr, target, 0, peak, true); // Search in the ascending part of the array i.e. from index 0 to peak
        if (left != -1)
            return left;

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false); // If not found in the ascending part, search in the descending part of the array i.e. from index peak + 1 to end of the array
    }

    private static int findPeak(MountainArray arr) {
        int low = 0, high = arr.length() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int binarySearch(MountainArray arr, int target, int low, int high, boolean isAsc) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);

            if (val == target)
                return mid;

            if (isAsc) {
                if (val < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (val > target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] Marr = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;
        MountainArray mountainArr = new MountainArray(Marr);
        System.out.println(findInMountain(target, mountainArr));
    }
}
