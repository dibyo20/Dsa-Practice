import java.util.*;

public class wordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String newWord = new String(arr);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(begin, end, list));
    }
}
