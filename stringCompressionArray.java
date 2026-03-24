import java.util.ArrayList;

public class stringCompressionArray {
    public static int compressString(char str[]) {
        if (str.length == 0) {
            return 0;
        }

        if (str.length == 1) {
            return 1;
        }

        ArrayList<String> sb = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < str.length; i++) {
            if (i + 1 < str.length && str[i]==(str[i + 1])) {
                count++;
            } else {
                sb.add(String.valueOf(str[i]));
                // if (count > 1) {
                //     sb.add(Integer.toString(count));
                // }
                // count = 1;
                if (count > 1 && count < 10) {
                sb.add(Integer.toString(count));
                } else if (count >= 10) {
                int count1 = count / 10;
                int count2 = count % 10;
                sb.add(Integer.toString(count1));
                sb.add(Integer.toString(count2));
                }
                count = 1;
            }
        }
        return sb.size();
    }

    public static void main(String[] args) {
        char input[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        int result = compressString(input);
        System.out.println(result);
    }
}
