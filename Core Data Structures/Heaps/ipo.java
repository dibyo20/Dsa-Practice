import java.util.*;

public class ipo {
    public static class Project{
        int capital;
        int profit;

        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaxCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.capital, b.capital));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int i = 0; i < profits.length; i++){
            minCapitalHeap.add(new Project(capital[i], profits[i]));
        }

        while(k > 0){
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w){
                Project p = minCapitalHeap.poll();
                maxProfitHeap.add(p.profit);
            }

            if(maxProfitHeap.isEmpty()){
                break;
            }

            w += maxProfitHeap.poll();
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        int k = 2;
        int w = 0;
        System.out.println(findMaxCapital(k, w, profits, capital));
    }
}