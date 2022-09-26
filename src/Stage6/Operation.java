package Stage6;

import java.util.ArrayList;
import java.util.List;

import static Stage6.Property.*;


public class Operation {
    enum property {
        even, odd, buzz, duck, palindromic, gapful, spy, sunny, square
    }

    public Operation() {
        System.out.print("Welcome to Amazing Numbers!\n");
        request();
    }

    public Operation(int size, String[] arrayInput) {
        switch (size) {
            case 1 -> oneNum(arrayInput);
            case 2 -> twoNumber(arrayInput);
            case 3 -> twoNumberWithProperty(arrayInput);
            case 4 -> twoNumberWithTwoProperty(arrayInput);
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
        System.out.println("        buzz: " + buzzCheck(num));
        System.out.println("        duck: " + duckCheck(num));
        System.out.println(" palindromic: " + palindromic(num));
        System.out.println("      gapful: " + gapfulNumber(num));
        System.out.println("         spy: " + spy(num));
        System.out.println("      square: " + square(num));
        System.out.println("       sunny: " + sunny(num));
        System.out.println("        even: " + evenOrOdd(num));
        System.out.println("         odd: " + !evenOrOdd(num));
    }

    private static List<String> getNumberProperty(Long currentNumber) {
        List<String> allProperty = new ArrayList<>();
        if (buzzCheck(currentNumber)) {
            allProperty.add("buzz");
        }
        if (duckCheck(currentNumber)) {
            allProperty.add("duck");
        }
        if (palindromic(currentNumber)) {
            allProperty.add("palindromic");
        }
        if (gapfulNumber(currentNumber)) {
            allProperty.add("gapful");
        }
        if (spy(currentNumber)) {
            allProperty.add("spy");
        }
        if (square(currentNumber)) {
            allProperty.add("square");
        }
        if (sunny(currentNumber)) {
            allProperty.add("sunny");
        }
        if (evenOrOdd(currentNumber)) {
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

    private static void twoNumberWithProperty(String[] array) {
        long num1 = Long.parseLong(array[0]);
        long num2 = Long.parseLong(array[1]);
        String ope = array[2];
        for (int i = 1; i <= num2; ++num1) {
            List<String> arr = getNumberProperty(num1);
            if (arr.contains(ope.toLowerCase())) {
                ++i;
                System.out.print(num1 + " is ");
                print(arr);
            }
        }
    }

    private void twoNumberWithTwoProperty(String[] array) {
        long num1 = Long.parseLong(array[0]);
        long num2 = Long.parseLong(array[1]);
        String ope1 = array[2].toLowerCase();
        String ope2 = array[3].toLowerCase();
        for (int i = 1; i <= num2; ++num1) {
            List<String> arr = getNumberProperty(num1);
            if (arr.contains(ope1) && arr.contains(ope2)) {
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
                - two natural numbers and a property to search for;
                - two natural numbers and two properties to search for;
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


