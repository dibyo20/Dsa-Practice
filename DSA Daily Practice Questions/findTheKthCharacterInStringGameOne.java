public class findTheKthCharacterInStringGameOne {
    public static char kthCharacter(int k) {
        int increments = 0;
        int length = 1;

        while (length < k) {
            length *= 2;
        }

        while (k > 1) {
            if (k > length / 2) {
                k -= length / 2;
                increments++;
            }

            length /= 2;
        }

        return (char) ('a' + increments);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
