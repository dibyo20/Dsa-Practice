public class peakMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        int largest = Integer.MIN_VALUE;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                if (arr[mid] > largest) {
                    largest = mid;
                    end = mid;
                }
            } else {
                if (arr[mid + 1] > largest) {
                    largest = mid + 1;
                }
                start = mid + 1;
            }
        }
        return largest;

    }

    public static void main(String[] args) {
        int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
        int result = peakIndexInMountainArray(arr);
        System.out.println("Peak index is: " + result);
    }
}



// int start = 0, end = arr.length - 1;

//         while (start < end) {
//             int mid = start + (end - start) / 2;
//             if (arr[mid] > arr[mid + 1]) {
//                 end = mid;
//             } else {
//                 start = mid + 1;
//             }
//         }
//         return start;
