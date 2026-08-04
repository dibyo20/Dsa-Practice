public class stringCompression {
    public static int compress(char[] str) {
        int n = str.length;
        if (n <= 1) {
            return n;
        }

        int left = 0;
        int right = 0;
        int write = 0;
        int count = 0;

        while (right < n) {
            while (right < n && str[left] == str[right]) {
                right++;
            }

            count = right - left;
            str[write++] = str[left];
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    str[write++] = c;
                }
            }
            left = right;
        }
        return write;
    }

    public static void main(String[] args) {
        char[] str = { 'a' };
        System.out.println(compress(str));
    }
}
