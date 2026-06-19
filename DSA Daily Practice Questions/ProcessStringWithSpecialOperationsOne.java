public class processStringWithSpecialOperationsOne {
    public static String processString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                result.append(result);
            } else if (ch == '%') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "a#b%*";
        System.out.println(processString(s));
    }
}
