public class fastexponent {
    public static int fastExponent(int a, int n) {
        int ans = 1;
        while(n>0) {
            if((n & 1) != 0) { // Check LSB
                ans = ans * a;
            }
            a = a * a; // Square the base
            n = n >> 1; // Divide n by 2
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastExponent(3, 5)); 
    }
}
