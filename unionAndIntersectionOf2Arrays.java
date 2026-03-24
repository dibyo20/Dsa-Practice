import java.util.*;

public class unionAndIntersectionOf2Arrays {
    public static void main(String[] args) {
        int[] arr1 = { 7, 3, 9 };
        int[] arr2 = { 6, 3, 9, 2, 9, 4 };

        // Union
        HashSet<Integer> unionSet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            unionSet.add(i);
        }
        for (int i = 0; i < arr2.length; i++) {
            unionSet.add(i);
        }
        System.out.println("Union: " + unionSet.size());

        // Intersection
        unionSet.clear();
        for (int i = 0; i < arr1.length; i++) {
            unionSet.add(arr1[i]);
        }

        int Count = 0;
        for(int i = 0; i < arr2.length; i++) {
            if (unionSet.contains(arr2[i])) {
                Count++;
                unionSet.remove(arr2[i]); // Remove to avoid counting duplicates
            }
        }
        System.out.println("Intersection: " + Count);
    }
}
