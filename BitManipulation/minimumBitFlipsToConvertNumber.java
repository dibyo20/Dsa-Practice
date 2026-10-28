public class minimumBitFlipsToConvertNumber {
    public static int minBitFlips(int start, int end) {
        return Integer.bitCount(start ^ end);
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
    }
}
