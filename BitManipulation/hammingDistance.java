public class hammingDistance {
    public static int hammingDist(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDist(1, 4));
    }
}
