public class recurssionincreasingorder {
    public static void increasing(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        increasing(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10; 
        increasing(n);
    }
}
