public class findTheDifference {
    public static char difference(String s, String t) {
        char result = 0;

        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(difference("abcd", "abcde"));
    }
}
