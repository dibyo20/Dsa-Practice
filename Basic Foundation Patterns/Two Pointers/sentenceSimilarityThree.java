public class sentenceSimilarityThree {
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        String[] small, large;
        if (words1.length <= words2.length) {
            small = words1;
            large = words2;
        } else {
            small = words2;
            large = words1;
        }

        int left = 0;
        while (left < small.length) {
            if (small[left].equals(large[left])) {
                left++;
            } else {
                break;
            }
        }

        int i = small.length - 1;
        int j = large.length - 1;
        while (i >= left) {
            if (small[i].equals(large[j])) {
                i--;
                j--;
            } else {
                break;
            }
        }

        return left > i;
    }

    public static void main(String[] args) {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }
}
