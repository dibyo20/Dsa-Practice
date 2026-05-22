public class decimalToBinary {
    public static void main(String args[]) {
        int n = 13;
        String binary = "";
        while (n != 0) {
            binary = (n % 2) + binary;
            n /= 2;
        }
        System.out.println(binary);
    }
}
