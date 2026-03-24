public class trie {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // TC: O(L), where L is the maximum length of the word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.eow = true; // mark the end of the word
    }

    public static boolean search(String word) { // TC: O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                return false; // word not found
            }
            curr = curr.children[index];
        }
        return curr.eow; // return true if it is end of the word
    }

    public static void main(String args[]) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        String searchWords[] = { "the", "these", "their", "any", "thee" };
        for (int i = 0; i < searchWords.length; i++) {
            if (search(searchWords[i])) {
                System.out.println(searchWords[i] + " is present in the trie");
            } else {
                System.out.println(searchWords[i] + " is not present in the trie");
            }
        }
    }
}
