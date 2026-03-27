public class findSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char ans = letters[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                ans = letters[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'c';

        System.out.println(nextGreatestLetter(letters, target));
    }
}
