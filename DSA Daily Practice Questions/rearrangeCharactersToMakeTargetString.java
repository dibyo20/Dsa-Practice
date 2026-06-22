public class rearrangeCharactersToMakeTargetString {
    public static int rearrangeCharacters(String s, String target) {
        if(s.length() < target.length()){
            return 0;
        }

        int[] sArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }

        int[] targetArr = new int[26];
        for (int i = 0; i < target.length(); i++) {
            targetArr[target.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (targetArr[i] != 0) {
                min = Math.min(min, sArr[i] / targetArr[i]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("aacc", "cc"));
    }
}
