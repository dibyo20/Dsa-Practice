import java.util.*;

public class searchSuggestionsSystem {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        int left = 0;
        int right = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            while (products[left].length() <= i || products[left].charAt(i) != c) {
                left++;
            }

            while (products[right].length() <= i || products[right].charAt(i) != c) {
                right--;
            }

            List<String> suggestions = new ArrayList<>();
            for (int j = left; j <= Math.min(left + 2, right); j++) {
                suggestions.add(products[j]);
            }
            result.add(suggestions);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
    }
}
