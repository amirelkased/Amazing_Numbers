package Stage2;

import java.util.Scanner;

public class DuckNumbers {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        int num = scanner.nextInt();
        if (num > 0) {
            System.out.println("Properties of " + num);
            System.out.println("        even: " + evenOrOdd(num));
            System.out.println("         odd: " + !evenOrOdd(num));
            System.out.println("        buzz: " + buzzCheck(num));
            System.out.println("        duck: " + duckCheck(num));
        } else {
            System.out.println("This number is not natural!");
        }
    }

    private static boolean evenOrOdd(int num) {
        return num % 2 == 0;
    }

    private static boolean buzzCheck(int num) {
        return num % 10 == 7 || num % 7 == 0;
    }

    private static boolean duckCheck(int num) {
        return String.valueOf(num).contains("0");
    }
}
