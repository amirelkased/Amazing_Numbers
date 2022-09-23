package Stage3;

import java.util.Scanner;

public class PalindromicNumbers {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Welcome to Amazing Numbers!
                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.
                """);
        while (true) {
            System.out.println("Enter a request:");
            long num = scanner.nextLong();
            if (num > 0) {
                System.out.println("Properties of " + num);
                System.out.println("        even: " + evenOrOdd(num));
                System.out.println("         odd: " + !evenOrOdd(num));
                System.out.println("        buzz: " + buzzCheck(num));
                System.out.println("        duck: " + duckCheck(num));
                System.out.println(" palindromic: " + palindromic(num));
            } else {
                if (num == 0) {
                    System.out.println("Goodbye!");
                    return;
                }
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }

    private static boolean evenOrOdd(long num) {
        return num % 2 == 0;
    }

    private static boolean buzzCheck(long num) {
        return num % 10 == 7 || num % 7 == 0;
    }

    private static boolean duckCheck(long num) {
        return String.valueOf(num).contains("0");
    }

    private static boolean palindromic(long num) {
        String number = String.valueOf(num);
        for (int i = 0, j = number.length() - 1; i <= j; i++, --j) {
            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
