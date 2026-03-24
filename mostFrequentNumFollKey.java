import java.util.*;

public class mostFrequentNumFollKey {

    public static int mostFrequentNum(ArrayList<Integer> array, int key) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) == key) {
                int target = array.get(i + 1);
                freq.put(target, freq.getOrDefault(target, 0) + 1); // sets frequency of the number following the key.
            }
        }

        int maxFreq = 0;
        int result = -1;

        ArrayList<Integer> keys = new ArrayList<>(freq.keySet()); // Get all keys from the frequency map and store in a list.

        for (int i = 0; i < keys.size(); i++) {
            int keyVal = keys.get(i);  // Access each key.
            int value = freq.get(keyVal);  // Get the frequency value for the key.

            if (value > maxFreq) {
                maxFreq = value;
                result = keyVal;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        ArrayList<Integer> array = new ArrayList<>();
        int key = 1;

        array.add(1);
        array.add(100);
        array.add(200);
        array.add(1);
        array.add(100);

        System.out.print(mostFrequentNum(array, key));
    }
}
