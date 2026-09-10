import java.util.*;

public class onlineStockSpan {
    public static class StockSpanner {
        Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int[] arr = { price, 1 };
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                int[] top = stack.pop();
                arr[1] += top[1];
            }
            stack.push(arr);
            return arr[1];
        }
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        int day1 = obj.next(100);
        int day2 = obj.next(80);
        int day3 = obj.next(60);
        int day4 = obj.next(70);
        int day5 = obj.next(60);
        int day6 = obj.next(75);
        System.out.println(day1 + " " + day2 + " " + day3 + " " + day4 + " " + day5 + " " + day6);
    }
}
