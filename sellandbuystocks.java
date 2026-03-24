public class sellandbuystocks {
    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // If the current price is greater than the buy price, update the buy price
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else {
                // If the current price is less than the buy price, update the buy price
                buyPrice = prices[i];
            }
            
        }
        return maxProfit;
    } 
    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = buyAndSellStocks(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
