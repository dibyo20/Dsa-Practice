public class maximumIceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        if (costs.length == 0)
            return 0;

        int freq[] = new int[100001];
        int maxCost = 0;
        for (int i = 0; i < costs.length; i++) {
            freq[costs[i]]++;
            maxCost = Math.max(maxCost, costs[i]);
        }

        int ans = 0;
        for (int i = 1; i <= maxCost; i++) {
            if (coins < i) {
                break;
            }
            int canBuy = Math.min(freq[i], coins / i);
            ans += canBuy;
            coins -= canBuy * i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] costs = { 1, 6, 3, 1, 2, 5 };
        int coins = 20;
        System.out.println(maxIceCream(costs, coins));
    }
}
