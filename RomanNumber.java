import java.util.HashMap;

public class RomanNumber {
    private static final HashMap<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static int romanToArabic(String romanNumber) {
        int result = 0;
        int prevValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int value = romanMap.get(romanNumber.charAt(i));

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        if (!arabicToRoman(result).equals(romanNumber)) {
            throw new IllegalArgumentException("Результат отрицательный!");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Римские числа меньше 1 недопустимы!");
        }

        StringBuilder result = new StringBuilder();

        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        while (number > 0) {
            if (number - numbers[i] >= 0) {
                result.append(symbols[i]);
                number -= numbers[i];
            } else {
                i++;
            }
        }

        return result.toString();
    }
}
