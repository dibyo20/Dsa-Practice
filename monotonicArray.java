import java.util.ArrayList;

public class monotonicArray {
    public static boolean isMonotonic(ArrayList<Integer> array){
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for(int i=0; i<array.size()-1; i++){
            if(array.get(i) > array.get(i+1)){
                isIncreasing = false;
            }
            if(array.get(i) < array.get(i+1)){
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(2);
        array.add(3);
        System.out.println(isMonotonic(array)); // true

        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(6);
        array2.add(5);
        array2.add(4);
        array2.add(4);
        System.out.println(isMonotonic(array2)); // true

        ArrayList<Integer> array3 = new ArrayList<>();
        array3.add(1);
        array3.add(3);
        array3.add(2);
        System.out.println(isMonotonic(array3)); // false
    }
}
