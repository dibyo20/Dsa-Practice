public class largestofstring {
    public static void main(String args[]){
        String fruits[] = {"Apple", "Banana", "Cherry", "Mango", "Pineapple"};
        String largest = fruits[0];
        for(int i=1; i<fruits.length; i++){
            if(largest.compareTo(fruits[i]) < 0){     // compareTo returns a negative value if the first string is lexicographically less than the second
                largest = fruits[i];
            }
        }
        System.out.println("The largest string is: " + largest);
    }
}
