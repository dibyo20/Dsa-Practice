public class reversePrefixOfWord {
    public static String reversePrefix(String word, char ch) {
        int left = 0;
        int right = 0;
        while (right < word.length()) {
            if (word.charAt(right) == ch) {
                break;
            }
            right++;
        }
        if (right == word.length()) {
            return word;
        }
        String arr[] = word.split("");
        while (left <= right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.join("", arr);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
