public class wordBreakProblem {
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

    public static boolean wordBreak(String key) { // TC: O(N^2 * L), where N is the length of the key and L is the maximum length of the word in the dictionary
        if (key.length() == 0) { // Base case: if the string is empty, return true
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            if (search(prefix)) {
                // If prefix is found, check the remaining substring
                if (wordBreak(key.substring(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilikesamsung";
        if (wordBreak(key)) {
            System.out.println("The string is present");
        } else {
            System.out.println("The string is not present");
        }
    }
}
