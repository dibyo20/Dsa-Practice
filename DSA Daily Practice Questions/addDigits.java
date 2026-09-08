public class addDigits {
    public static int add(int num) {
        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        System.out.println(add(38));
    }
}
