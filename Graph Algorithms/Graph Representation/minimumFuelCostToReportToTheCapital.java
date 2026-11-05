import java.util.*;

public class minimumFuelCostToReportToTheCapital {
    public static long fuel = 0;

    public static long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < roads.length + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }

        dfs(0, -1, adj, seats);
        return fuel;
    }

    private static int dfs(int node, int parent, List<List<Integer>> adj, int seats) {
        int people = 1;

        for (int child : adj.get(node)) {
            if (child != parent) {
                people += dfs(child, node, adj, seats);
            }
        }

        if (node != 0) {
            int cars = (people + seats - 1) / seats;
            fuel += cars;
        }
        
        return people;
    }

    public static void main(String[] args) {
        int[][] roads = { { 3, 1 }, { 3, 2 }, { 1, 0 }, { 0, 4 }, { 0, 5 }, { 4, 6 } };
        int seats = 2;
        System.out.println(minimumFuelCost(roads, seats));
    }
}
