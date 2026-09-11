public class findFirstPalindromicStringInTheArray {
    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            int left = 0;
            int right = word.length() - 1;
            while (left < right) {
                if (word.charAt(left) != word.charAt(right)) {
                    break;
                }
                left++;
                right--;
            }
            if (left >= right) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        String result = firstPalindrome(words);
        System.out.println(result);
    }
}
