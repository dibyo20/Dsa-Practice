public class WeightedWordMapping {
    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder mapped = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int sum = 0;

            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                sum += weights[ch - 'a'];
            }
            
            int mod = sum % 26;
            mapped.append((char) ('z' - mod));
        }
        return mapped.toString();
    }

    public static void main(String[] args) {
        String[] words = { "abcd", "def", "xyz" };
        int[] weights = { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 };
        System.out.println(mapWordWeights(words, weights));
    }
}
