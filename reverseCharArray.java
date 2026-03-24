import java.util.Arrays;

public class reverseCharArray {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] arr = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Original: " + Arrays.toString(arr));
        reverseString(arr);
        System.out.println("Reversed: " + Arrays.toString(arr));
    }
}
