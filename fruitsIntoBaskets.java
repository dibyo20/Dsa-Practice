import java.util.*;

public class fruitsIntoBaskets {
    public static int totalFruits(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxlength = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            maxlength = Math.max(maxlength, right - left + 1);
        }

        return maxlength;
    }

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 3, 2, 2 };
        System.out.println("Maximum fruits collected: " + totalFruits(fruits));
    }
}
