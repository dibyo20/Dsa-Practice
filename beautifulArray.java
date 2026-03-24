import java.util.*;

public class beautifulArray {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);  // Start with adding 1 to the array, so that we can build upon it.

        while (result.size() < n) {  // Keep building the array until its size reaches n.
            ArrayList<Integer> temp = new ArrayList<>();  // temp is initailized every iteration to store new values.

            for (int i = 0; i < result.size(); i++) {  // Generate odd indexed values.
                int x = result.get(i);
                int oddVal = 2 * x - 1;

                if (oddVal <= n) {
                    temp.add(oddVal);
                }
            }

            for (int i = 0; i < result.size(); i++) {  // Generate even indexed values.
                int x = result.get(i);
                int evenVal = 2 * x;

                if (evenVal <= n) {
                    temp.add(evenVal);
                }
            }

            result = temp; // Update result with the newly formed array.
        }

        return result; // Return the beautiful array of size n.
    }

    public static void main(String[] args) {
        System.out.println(beautifulArray(4));
        System.out.println(beautifulArray(5));
    }
}
