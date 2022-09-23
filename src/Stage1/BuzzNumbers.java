package Stage1;

import java.util.Scanner;


public class BuzzNumbers {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        int num = scanner.nextInt();
        if (num > 0) {
            switch (check(num)) {
                case 1 -> System.out.println("Explanation:\n" + num + " is divisible by 7 and ends with 7.");
                case 2 -> System.out.println("Explanation:\n" + num + " ends with 7.");
                case 3 -> System.out.println("Explanation:\n" + num + " is divisible by 7.");
                default -> System.out.println("Explanation:\n" + num
                        + " is neither divisible by 7 nor does it end with 7.");
            }
        } else {
            System.out.println("This number is not natural!");
        }
    }

    private static int check(int num) {
        System.out.println(num % 2 == 0 ? "This number is Even.\n" : "This number is Odd.\n");
        if (num % 10 == 7 && num % 7 == 0) {
            System.out.println("This number is Odd.\nIt is a Buzz number.");
            return 1;
        }
        if (num % 10 == 7) {
            System.out.println("This number is Odd.\nIt is a Buzz number.");
            return 2;
        }
        if (num % 7 == 0) {
            System.out.println("This number is Odd.\nIt is a Buzz number.");
            return 3;
        }
        System.out.println("It is not a Buzz number.");
        return -1;
    }
}