import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];

        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[changed.length / 2];
        int index = 0;

        for (int num : changed) {

            if (freq.get(num) == 0)
                continue;

            if (freq.getOrDefault(num * 2, 0) == 0)
                return new int[0];

            original[index++] = num;

            freq.put(num, freq.get(num) - 1);
            freq.put(num * 2, freq.get(num * 2) - 1);
        }

        return original;
    }

    public static void main(String[] args) {
        int []changed = {1, 3, 4, 2, 6, 8};
        findOriginalArrayFromDoubledArray solution = new findOriginalArrayFromDoubledArray();
        int[] original = solution.findOriginalArray(changed);
        System.out.println(Arrays.toString(original));
    }
}
