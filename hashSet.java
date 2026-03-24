import java.util.*;

public class hashSet {
    public static void main(String args[]) {
        HashSet<String> set = new HashSet<>();
        set.add("India");
        set.add("USA");
        set.add("China");
        set.add("Japan");
        set.add("Germany");
        set.add("France");

        System.out.println("Initial set: " + set);

        // Check if a specific element exists
        // System.out.println("Contains 'India': " + set.contains("India"));

        // Remove an element
        // set.remove("USA");
        // System.out.println("Set after removing 'USA': " + set);

        // Check the size of the set
        // System.out.println("Size of the set: " + set.size());

        // Iterate through the set using iterator
        Iterator<String> itr = set.iterator(); // Create an iterator for the set
        System.out.println("Elements in the set:");
        while (itr.hasNext()) { // hasNext() checks if there are more elements
            System.out.println(itr.next()); // next() retrieves the next element in the iteration
        }

        // Iterate through the set using for-each loop
        for (String country : set) {
            System.out.println("Country: " + country);
        }
    }
}
