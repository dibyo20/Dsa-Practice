import java.util.*;

public class operationsarrayList {
    public static void main(String args[]){
        // ArrayList<Integer> list = new ArrayList<>();
        // // ArrayList<Integer> list2 = new ArrayList<>();

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(6);
        // list.add(8);
        // System.out.println("Original List: " + list);

        // int element = list.get(2); // Get element at index 2
        // System.out.println("Element at index 2: " + element);

        // list2.add(6);
        // list2.add(7);
        // System.out.println("Second List: " + list2);

        // list.set(3, 10);
        // System.out.println("List after setting index 3 to 10: " + list);

        // System.out.println("Size of the first list: " + list.size());
        // System.out.println("Size of the second list: " + list2.size());

        //Reverse the list  
        // for(int i=list.size()-1; i>=0; i--){  // TC: O(n)
        //     System.out.print(list.get(i) + " ");
        // }

        //Maximum element in the list
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<list.size(); i++){  // TC: O(n)
        //     if(list.get(i) > max){
        //         max = list.get(i);
        //     }
        // }
        // System.out.println("\nMaximum element in the list: " + max);

        //Swap two elements in the list
        // int index1 = 1; 
        // int index2 = 3; 
        // int temp = list.get(index1);
        // list.set(index1, list.get(index2));
        // list.set(index2, temp);
        // System.out.println("List after swapping elements at indices " + index1 + " and " + index2 + ": " + list);

        //Sorting the list
        // Collections.sort(list);     // TC: O(n log n),  Sort in ascending order
        // System.out.println("Sorted List: " + list);
        // Collections.sort(list, Collections.reverseOrder()); // Sort in descending order
        // System.out.println("List sorted in descending order: " + list);

        // Multi Dimensional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> subList1 = new ArrayList<>();
        subList1.add(1);
        subList1.add(2);
        mainList.add(subList1);

        ArrayList<Integer> subList2 = new ArrayList<>();
        subList2.add(3);
        subList2.add(4);
        mainList.add(subList2);
        System.out.println("Multi Dimensional ArrayList: " + mainList);

        for(int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currentList = mainList.get(i);
            for(int j = 0; j < mainList.get(i).size(); j++) {
                System.out.print(currentList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
