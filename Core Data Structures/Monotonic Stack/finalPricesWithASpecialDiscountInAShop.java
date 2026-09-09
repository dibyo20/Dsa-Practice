import java.util.*;

public class finalPricesWithASpecialDiscountInAShop {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? 0 : prices[stack.peek()];
            stack.push(i);
        }
        for (int i = 0; i < prices.length; i++) {
            prices[i] -= nextSmaller[i];
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] prices = { 8, 4, 6, 2, 3 };
        int[] result = finalPrices(prices);
        System.out.println(Arrays.toString(result));
    }
}
