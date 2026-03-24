public class startsWithProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word

        public Node() {
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

    public static boolean startswith(String prefix) { // TC: O(L)
        Node curr = root;
        for (int level = 0; level < prefix.length(); level++) {
            int index = prefix.charAt(level) - 'a';
            if (curr.children[index] == null) {
                return false; // prefix not found
            }
            curr = curr.children[index];
        }
        return true; // prefix found
    }
public static void main(String args[]) {
        String words[] = { "apple", "app", "mango", "woman" };
        String prefix1 = "app";
        String prefix2 = "moon";

        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(prefix1);
        System.out.println(prefix2);
        
    }
}
