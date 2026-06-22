public class maximumNumberOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        if (text.length() < 7)
            return 0;

        String balloon = "balloon";

        int[] textArr = new int[26];
        for (int i = 0; i < text.length(); i++) {
            textArr[text.charAt(i) - 'a']++;
        }

        int[] balloonArr = new int[26];
        for (int i = 0; i < balloon.length(); i++) {
            balloonArr[balloon.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (balloonArr[i] != 0) {
                min = Math.min(min, textArr[i] / balloonArr[i]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}
