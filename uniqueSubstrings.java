public class uniqueSubstrings {
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

    public static int countNodes(Node node) {
        if (node == null)
            return 0;

        int count = 1; // count this node
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(node.children[i]); // count all children nodes
            }
        }
        return count;
    }

    public static void main(String args[]) {
        String str = "apple";

        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println("Total unique substrings: " + countNodes(root));
    }
}
