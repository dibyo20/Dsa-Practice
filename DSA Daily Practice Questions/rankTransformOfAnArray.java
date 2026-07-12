import java.util.*;

public class rankTransformOfAnArray {
    public static int[] arrayRankTransform(int[] arr) {
        int copyArr[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < copyArr.length; i++) {
            if (i == 0 || copyArr[i] != copyArr[i - 1]) {
                map.put(copyArr[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[] { 40, 10, 20, 30 })));
    }
}
