public class numberOfStringsThatAppearAsSubstringsInWord {
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] patterns = { "a", "abc", "bc", "d" };
        String word = "abcde";
        System.out.println(numOfStrings(patterns, word));
    }
}
