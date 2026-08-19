public class shiftingLettersTwo {
    public static String shifLetters(String s, int[][] shifts) {
        int dist[] = new int[s.length()];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];

            int shift = direction == 1 ? +1 : -1;

            dist[start] += shift;
            if (end + 1 < s.length()) {
                dist[end + 1] -= shift;
            }
        }

        for (int i = 1; i < s.length(); i++) {
            dist[i] += dist[i - 1];
        }

        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int shift = dist[i] % 26;
            arr[i] = (char) ((arr[i] - 'a' + shift + 26) % 26 + 'a');
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = { {0, 1, 0}, {1, 2, 1}, {0, 2, 1} };
        System.out.println(shifLetters(s, shifts));
    }
}
