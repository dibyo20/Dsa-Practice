public class verifyPreorderSerializationOfABinaryTree {
    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1;
        for (String node : nodes) {
            if (slots == 0) {
                return false;
            }

            if (node.equals("#")) {
                slots--;
            } else {
                slots++;
            }
        }
        return slots == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
