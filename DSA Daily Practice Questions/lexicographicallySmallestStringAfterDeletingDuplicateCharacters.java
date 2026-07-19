public class lexicographicallySmallestStringAfterDeletingDuplicateCharacters {
    public static String lexSmallestAfterDeletion(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            while (stack.length() > 0
                    && stack.charAt(stack.length() - 1) > c
                    && cnt[stack.charAt(stack.length() - 1) - 'a'] > 1) {

                cnt[stack.charAt(stack.length() - 1) - 'a']--;
                stack.deleteCharAt(stack.length() - 1);
            }
            stack.append(c);
        }

        while (stack.length() > 0
                && cnt[stack.charAt(stack.length() - 1) - 'a'] > 1) {

            cnt[stack.charAt(stack.length() - 1) - 'a']--;
            stack.deleteCharAt(stack.length() - 1);
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(lexSmallestAfterDeletion("aaccb"));
        System.out.println(lexSmallestAfterDeletion("z"));
        System.out.println(lexSmallestAfterDeletion("abccba"));
        System.out.println(lexSmallestAfterDeletion("aaaa"));
        System.out.println(lexSmallestAfterDeletion("cbcb"));
    }
}
