public class removeAllAdjacentDuplicatesInStringTwo {
    public static String removeDuplicates(String s, int k) {
        if (s.length() < k)
            return s;

        char[] stack = new char[s.length()];
        int[] count = new int[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            if (top == -1 || s.charAt(i) != stack[top]) {
                top++;
                stack[top] = s.charAt(i);
                count[top] = 1;
            } else {
                count[top]++;
                if (count[top] == k) {
                    top--;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans.append(stack[i]);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
