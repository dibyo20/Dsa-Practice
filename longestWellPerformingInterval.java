import java.util.HashMap;

public class longestWellPerformingInterval {
    public static int longestWPI(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i < hours.length; i++) {
            if(hours[i] > 8)
                sum += 1;
            else
                sum -= 1;

            if(sum > 0) {
                maxLen = i + 1;
            } 
            else {
                if(map.containsKey(sum - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(sum - 1));
                }
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int hours[] = {9,9,6,0,6,6,9};
        System.out.println(longestWPI(hours));
    }
}
