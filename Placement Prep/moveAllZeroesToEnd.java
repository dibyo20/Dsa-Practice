import java.util.*;

public class moveAllZeroesToEnd {
    public static void main(String args[]) {
        int arr1[] = { 1, 2, 0, 0, 0, 3, 6 };
        int n = arr1.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != 0) {
                arr1[index++] = arr1[i];
            }
        }
        while (index < n) {
            arr1[index++] = 0;
        }

        System.out.println(Arrays.toString(arr1));
    }
}
