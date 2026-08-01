import java.util.HashMap;

public class fractionsToRecurringDecimal {
    public static String fractionsToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder result = new StringBuilder();

        if (numerator < 0 ^ denominator < 0)
            result.append("-"); // ^ this is XOR operator, it will return true if one of the conditions is true,
                                // but not both. Instead of using ^ we can also use (numerator < 0 &&
                                // denominator > 0) || (numerator > 0 && denominator < 0).

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);

        long rem = num % den;

        if (rem == 0)
            return result.toString();

        result.append(".");

        HashMap<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            map.put(rem, result.length());
            rem *= 10;
            result.append(rem / den);
            rem %= den;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int numerator = 1, denominator = 4;
        System.out.println(fractionsToDecimal(numerator, denominator));
    }
}
