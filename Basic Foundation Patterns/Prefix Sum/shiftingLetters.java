public class shiftingLetters {
    public static String shifLetters(String s, int[] shifts) {
        int totalShifts = 0;
        char[] arr = s.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShifts = (totalShifts + shifts[i]) % 26;
            arr[i] = (char) ((arr[i] - 'a' + totalShifts) % 26 + 'a');
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(shifLetters("abc", new int[] { 3, 5, 9 }));
    }
}
