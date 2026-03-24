public class ransomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int freq[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']++;
        }

        // for (char c : magazine.toCharArray()) {
        //     if (freq[c - 'a'] > 0) {
        //         freq[c - 'a']--;
        //     }
        // }

        // for (int count : freq) {
        //     if (count != 0) {
        //         return false;
        //     }
        // }

        int remaining = ransomNote.length();
        for (char c : magazine.toCharArray()) {
            if (freq[c - 'a'] > 0) {
                freq[c - 'a']--;
                remaining--;
                if (remaining == 0) {
                    return true;
                }
            }
        }

        return false;
        // return true;

    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("a", "b"));
    }
}
