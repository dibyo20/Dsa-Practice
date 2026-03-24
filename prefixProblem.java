public class prefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word
        int freq = 0;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // TC: O(L), where L is the maximum length of the word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            } else {
                curr.children[index].freq++;
            }
            curr = curr.children[index];
        }
        curr.eow = true; // mark the end of the word
    }

    public static void printPrefix(Node root, String ans, int idx) {
        if (root == null) {
            return;
        }

        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                printPrefix(root.children[i], ans + (char) (i + 'a'), idx);
            }
        }
    }

    public static void main(String args[]) {
        String arr[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        root.freq = -1;
        printPrefix(root, "", 0);
    }
}
