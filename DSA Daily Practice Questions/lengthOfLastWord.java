public class lengthOfLastWord {
    public static int lengthOfWord(String s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int len = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfWord("   fly me   to   the moon  "));
    }
}
