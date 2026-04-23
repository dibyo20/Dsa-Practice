import java.util.*;

public class wordSearchTwo {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Each node is a array of size 26, so to accomodate all 26 letters of
                                                // the alphabet.
        String word; // Stores full word at end node
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }

            node.word = word; // Set the end node of a word as that word, so that we can know while traversing
                              // that we have found a word.
        }

        return root;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null)
            return; // stop if visited or no match in Trie

        node = node.children[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Change the word to null to avoid duplicates
        }

        board[i][j] = '#'; // Mark visited

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                dfs(board, ni, nj, node, result);
            }
        }

        board[i][j] = c;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };

        String[] words = { "oath", "pea", "eat", "rain" };
        List<String> result = findWords(board, words);

        System.out.println("Words found:");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
