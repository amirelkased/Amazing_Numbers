package Stage7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static Stage7.Property.*;


public class Operation {
    enum property {
        even, odd, buzz, duck, palindromic, gapful, spy, sunny, jumping, square
    }

    public Operation() {
        System.out.print("Welcome to Amazing Numbers!\n");
        request();
    }

    public Operation(int size, String[] arrayInput) {
        switch (size) {
            case 1 -> oneNum(arrayInput);
            case 2 -> twoNumber(arrayInput);
            default -> twoNumberWithProperties(arrayInput);
        }
    }

    private void oneNum(String[] array) {
        if ("".equals(array[0])) {
            request();
        } else {
            long num = Long.parseLong(array[0]);
            oneNumber(num);
        }
    }

    private static void oneNumber(long num) {
        System.out.println("Properties of " + num);
        System.out.println("        buzz: " + isBuzz(num));
        System.out.println("        duck: " + isDuck(num));
        System.out.println(" palindromic: " + isPalindromic(num));
        System.out.println("      gapful: " + isGapful(num));
        System.out.println("         spy: " + isSpy(num));
        System.out.println("      square: " + isSquare(num));
        System.out.println("       sunny: " + sunny(num));
        System.out.println("     jumping: " + isJumping(num));
        System.out.println("        even: " + isEvenOrOdd(num));
        System.out.println("         odd: " + !isEvenOrOdd(num));
    }

    private static List<String> getNumberProperty(Long currentNumber) {
        List<String> allProperty = new ArrayList<>();
        if (isBuzz(currentNumber)) {
            allProperty.add("buzz");
        }
        if (isDuck(currentNumber)) {
            allProperty.add("duck");
        }
        if (isPalindromic(currentNumber)) {
            allProperty.add("palindromic");
        }
        if (isGapful(currentNumber)) {
            allProperty.add("gapful");
        }
        if (isSpy(currentNumber)) {
            allProperty.add("spy");
        }
        if (isSquare(currentNumber)) {
            allProperty.add("square");
        }
        if (sunny(currentNumber)) {
            allProperty.add("sunny");
        }
        if (isJumping(currentNumber)) {
            allProperty.add("jumping");
        }
        if (isEvenOrOdd(currentNumber)) {
            allProperty.add("even");
        } else {
            allProperty.add("odd");
        }
        return allProperty;
    }

    private static void twoNumber(String[] array) {
        long num1 = Long.parseLong(array[0]);
        long num2 = Long.parseLong(array[1]);
        for (long i = 1; i <= num2; ++i, ++num1) {
            List<String> arr = getNumberProperty(num1);
            System.out.print(num1 + " is ");
            print(arr);
        }
    }

    private void twoNumberWithProperties(String[] array) {
        long num1 = Long.parseLong(array[0]);
        long num2 = Long.parseLong(array[1]);
        List<String> all = new ArrayList<>(Arrays.asList(array));
        all.remove(0);
        all.remove(0);
        for (int i = 1; i <= num2; ++num1) {
            List<String> arr = getNumberProperty(num1);
            if (new HashSet<>(arr).containsAll(all)) {
                ++i;
                System.out.print(num1 + " is ");
                print(arr);
            }
        }
    }

    public static void request() {
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameters show how many consecutive numbers are to be processed;
                - two natural numbers and properties to search for;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }

    private static void print(List<String> arr) {
        for (int k = 0; k < arr.size(); k++) {
            System.out.printf("%s", arr.get(k));
            if (k != arr.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
