import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 1 + 2 или I + II):");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");

        if(parts.length != 3) {
            throw new IllegalArgumentException("Неправильный формат ввода!");
        }

        String num1 = parts[0];
        String operator = parts[1];
        String num2 = parts[2];

        int number1, number2;
        boolean isRoman = Character.isLetter(num1.charAt(0)) || Character.isLetter(num2.charAt(0));

        int maxAllowedNumber = isRoman ? 10 : 10;
        int minAllowedNumber = 1;

        if (isRoman) {
            number1 = RomanNumber.romanToArabic(num1);
            number2 = RomanNumber.romanToArabic(num2);
        } else {
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);

            if (number1 < minAllowedNumber || number1 > maxAllowedNumber || number2 < minAllowedNumber || number2 > maxAllowedNumber) {
                throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно!");
            }
        }

        int result;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if(number2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль!");
                }
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Недопустимая операция!");
        }

        if (isRoman) {
            System.out.println("Результат: " + RomanNumber.arabicToRoman(result));
        } else {
            System.out.println("Результат: " + result);
        }
    }
}