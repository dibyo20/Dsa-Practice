public class tillingproblem {
    public static int tillingProblem(int n) {
        if(n==0 || n==1) {
            return 1; // Base case
        }

        int fnm1 = tillingProblem(n-1);  // vertical placement
        int fnm2 = tillingProblem(n-2);  // horizontal placement

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void main(String args[]){
        System.out.println(tillingProblem(3));
    }
}
