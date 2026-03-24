import java.util.*;

public  class sortByFrequency {
    public static String frequencySort(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<List<Character>> bucket = new ArrayList<>();

        for (int i = 0; i <= s.length(); i++) {
            bucket.add(new ArrayList<>());
        }

        for (char ch : freqMap.keySet()) {
            int freq = freqMap.get(ch);
            bucket.get(freq).add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (char ch : bucket.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        sortByFrequency sorter = new sortByFrequency();
        System.out.println(sorter.frequencySort("tree"));
    }

}
