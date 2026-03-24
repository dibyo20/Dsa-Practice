public class stringcompression {
    public static String compressString(String str) {
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(str.charAt(i));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        return sb.toString().length();
    }

    // String newstr = "";
    //     for (int i = 0; i < str.length(); i++) {   // O(n)
    //         Integer count = 1;
    //         while (i < str.length()-1 && str.charAt(i) == str.charAt(i + 1)) {
    //             count++;
    //             i++;
    //         }
    //         newstr += str.charAt(i);
    //         if (count > 1) {
    //             newstr += count.toString();
    //         }
    //     }
    //     return newstr;
    // }

    public static void main(String[] args) {
        String input = "aaabbbccdaa";
        String result = compressString(input);
        System.out.println(result); 
    }
}
