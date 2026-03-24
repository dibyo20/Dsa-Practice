import java.util.*;

public class lonelyNum {
    public static ArrayList<Integer> isLonely(ArrayList<Integer> array) {
        ArrayList<Integer> array2 = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            freq.put(num, freq.getOrDefault(num, 0) + 1); // Count frequency of each number
        }
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            if (freq.get(num) == 1 && !array.contains(num + 1) && !array.contains(num - 1)) {
                array2.add(num);
            }
        }
        return array2;
    }

    public static void main(String args[]) {
        ArrayList<Integer> array = new ArrayList<>();
        // array.add(10);
        // array.add(6);
        // array.add(5);
        // array.add(8);
        array.add(1);
        array.add(3);
        array.add(5);
        array.add(3);
        System.out.print(isLonely(array));
    }
}
