public class friendspair {
    public static int friendsPair(int n) {
        if(n==1 || n==2){
            return n; 
        }

        int fnm1 = friendsPair(n - 1);        // single person case

        int fnm2 = friendsPair(n - 2);        // pair case
        int pairWays = (n - 1) * fnm2;        // (n-1) ways to pair with one person

        int totalWays = fnm1 + pairWays;      // total ways is sum of both cases
        return totalWays;
    }

    public static void main(String[] args) {
        int n = 3; 
        System.out.println("Total ways to pair " + n + " friends: " + friendsPair(n));
    }
}
