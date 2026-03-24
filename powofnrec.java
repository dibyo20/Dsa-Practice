public class powofnrec {
    public static int pow(int n, int p) {
        if (p == 0) {
            return 1; 
        }
        return n * pow(n, p - 1); 
    }
    public static void main(String[] args) {
        int n = 2; 
        int p = 3; 
        int result = pow(n, p);
        System.out.println(n + " raised to the power of " + p + " is: " + result);
    }
}
