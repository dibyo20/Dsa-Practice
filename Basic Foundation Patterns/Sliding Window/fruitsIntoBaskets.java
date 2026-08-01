import java.util.HashMap;

public class fruitsIntoBaskets {
    public static int totalFruits(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left] - 1));

                if (fruits[left] == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 1 };
        System.out.println(totalFruits(fruits));
    }
}
