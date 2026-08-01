public class numberOfSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstring(String s) {
        int freq[] = new int[3];
        int subarrayCount = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                subarrayCount += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return subarrayCount;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstring("abcabc"));
    }
}
