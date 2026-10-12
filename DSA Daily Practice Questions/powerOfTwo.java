public class powerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && 1073741824 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }
}
