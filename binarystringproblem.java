public class binarystringproblem {
    public static void printBinaryStrings(int n, String str, int lastPlace) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // Append 0 and 1 to the string based on the last place
        printBinaryStrings(n - 1, str + "0", 0); // Always append 0 first
        if (lastPlace == 0) { // we can append 1 only if the last place is 0
            printBinaryStrings(n - 1, str + "1", 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        printBinaryStrings(n, "", 0);
    }
}
