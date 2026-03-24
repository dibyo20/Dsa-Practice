public class backtracknoOfpermutation {
    public static void findPermutation(String str, String ans) {
        if (str.length() == 0) { // base case
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) { // TC O(n*n!), SC O(n)
            char curr = str.charAt(i);
            // "abcde" = "ab" + "de" = "abde" , if we remove 'c'
            String newstr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newstr, ans + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }
}
