import java.util.*;

public class findAllPossibleRecipesFromGivenSupplies {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {
                adj.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            String supply = q.poll();
            if (!adj.containsKey(supply)) {
                continue;
            }

            for (String recipe : adj.get(supply)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    ans.add(recipe);
                    q.offer(recipe);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] recipes = { "bread", "sandwich", "burger" };
        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast", "flour"), Arrays.asList("bread", "meat"),
                Arrays.asList("sandwich", "meat"));
        String[] supplies = { "yeast", "flour", "meat" };

        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }
}
