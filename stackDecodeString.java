import java.util.Stack;

public class stackDecodeString {

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // handle multi-digit numbers, so that we get the exact digit as here each digit is initially a character.
                                         // So, we use the ASCII values to get the exact digit by subtracting it from charcater '0';
            }

            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                k = 0;
                current = new StringBuilder();
            }

            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(current);
                }

                current = prev;
            }

            else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[cv]"));
        System.out.println(decodeString("3[b2[v]]"));
    }
}
