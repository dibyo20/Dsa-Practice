import java.util.*;

public class wordSearchTwo {
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char c = board[i][j];

        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }

        root = root.children[c - 'a'];

        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '#';

        int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                dfs(board, ni, nj, root, result);
            }
        }

        board[i][j] = c;
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
            node.word = word;
        }
        return root;
    }

    public static void main(String[] args) {
        String[] words = { "oath", "pea", "eat", "rain" };
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };

        System.out.println(findWords(board, words));
    }
}
