public class maximumBalancedStringPartitions {

    public static int maxBalancedPartitions(String str) {

        int count = 0;
        int balance = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                balance++;
            } else if (str.charAt(i) == 'R') {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalancedPartitions(str)); // Output: 3
    }
}
