public class ransomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int freq[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']++;
        }

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
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
