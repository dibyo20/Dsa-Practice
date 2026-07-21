public class primePalindrome {
    public static int pP(int n) {
        if (n >= 8 && n <= 11)
            return 11;

        for (int i = 1;; i++) {
            int palindrome = makePalindrome(i);

            if (palindrome >= n && isPrime(palindrome)) {
                return palindrome;
            }
        }
    }

    public static int makePalindrome(int num) {
        int x = num;
        int palindrome = num;

        x /= 10;
        while (x > 0) {
            palindrome = palindrome * 10 + (x % 10);
            x /= 10;
        }
        return palindrome;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(pP(6));
    }
}
