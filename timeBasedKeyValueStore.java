import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class timeBasedKeyValueStore { // Class to implement the time-based key-value store.
    static class Pair { // Inner class to store the timestamp and value as a pair.
        int timestamp;
        String value;

        Pair(int t, String v) {
            this.timestamp = t;
            this.value = v;
        }
    }

    static HashMap<String, List<Pair>> map;

    public timeBasedKeyValueStore() { // Constructor to initialize the HashMap.
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) { // Method to set the value for a key at a given
                                                               // timestamp.
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) { // Method to get the value for a key at a given timestamp.
        if (!map.containsKey(key))
            return "";

        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) { // Binary search on values of the hashmap to find the value corresponding to the
                                // given timestamp.
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        timeBasedKeyValueStore timeMap = new timeBasedKeyValueStore();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }
}
