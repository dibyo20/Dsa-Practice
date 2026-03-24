public class lexographicallySmallestString {
    public static void main(String[] args) {

        int N = 3;
        int K = 25;

        char[] result = new char[N];

        // Step 1: fill with 'a'
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }

        // Step 2: remaining sum
        int remaining = K - N;

        // Step 3: fill from end
        int i = N - 1;
        while (remaining > 0 && i >= 0) {
            int add = Math.min(25, remaining);
            result[i] = (char) (result[i] + add);
            remaining -= add;
            i--;
        }

        System.out.println(new String(result));
    }
}
