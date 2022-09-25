package Stage5;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SpyNumbers {

    public class Main {
        static Scanner scanner = new Scanner(System.in);
        static Pattern pattern = Pattern.compile("[a-zA-Z]|-");

        enum property {
            even, odd, buzz, duck, palindromic, gapful, spy
        }

        public static void main(String[] args) {
            System.out.print("Welcome to Amazing Numbers!\n");
            request();
            while (true) {
                System.out.println("Enter a request:");
                String[] input = scanner.nextLine().split(" ");
                if (input.length == 1) {
                    if ("".equals(input[0])) {
                        request();
                    } else {
                        if (pattern.matcher(input[0]).find()) {
                            System.out.println("The first parameter should be a natural number or zero.");
                        } else if ("0".equals(input[0])) {
                            System.out.println("Goodbye!");
                            return;
                        } else {
                            long num = Long.parseLong(input[0]);
                            oneNumber(num);
                        }
                    }
                } else if (input.length == 2) {
                    checkInput(input);
                    twoNumber(Long.parseLong(input[0]), Long.parseLong(input[1]));
                } else { // length == 3
                    checkInput(input);
                    try {
                        property.valueOf(input[2].toLowerCase(Locale.ROOT));
                        twoNumberWithProperty(Long.parseLong(input[0]), Long.parseLong(input[1]),
                                input[2].toLowerCase(Locale.ROOT));
                    } catch (Exception x) {
                        System.out.println("""
                                The property [SUN] is wrong.
                                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]""");
                    }
                }
            }
        }


        private static void checkInput(String[] input) {
            if (pattern.matcher(input[0]).find()) {
                System.out.println("The first parameter should be a natural number or zero.");
                return;
            }
            if (pattern.matcher(input[1]).find()) {
                System.out.println("The second parameter should be a natural number.");
            }
        }

        private static void request() {
            System.out.println("""
                    Supported requests:
                    - enter a natural number to know its properties;
                    - enter two natural numbers to obtain the properties of the list:
                      * the first parameter represents a starting number;
                      * the second parameters show how many consecutive numbers are to be processed;
                    - two natural numbers and a property to search for;
                    - separate the parameters with one space;
                    - enter 0 to exit.
                    """);
        }

        private static void oneNumber(long num) {
            System.out.println("Properties of " + num);
            System.out.println("        buzz: " + buzzCheck(num));
            System.out.println("        duck: " + duckCheck(num));
            System.out.println(" palindromic: " + palindromic(num));
            System.out.println("      gapful: " + gapfulNumber(num));
            System.out.println("         spy: " + spy(num));
            System.out.println("        even: " + evenOrOdd(num));
            System.out.println("         odd: " + !evenOrOdd(num));
        }

        private static void twoNumberWithProperty(long num1, long num2, String ope) {
            for (int i = 1; i <= num2; ++num1) {
                boolean flag = false;
                List<String> arr = new ArrayList<>();
                if (buzzCheck(num1)) {
                    arr.add("buzz");
                    if (property.valueOf(ope) == property.buzz) {
                        ++i;
                        flag = true;
                    }
                }
                if (duckCheck(num1)) {
                    arr.add("duck");
                    if (property.valueOf(ope) == property.duck) {
                        ++i;
                        flag = true;
                    }
                }
                if (palindromic(num1)) {
                    arr.add("palindromic");
                    if (property.valueOf(ope) == property.palindromic) {
                        ++i;
                        flag = true;
                    }
                }
                if (gapfulNumber(num1)) {
                    arr.add("gapful");
                    if (property.valueOf(ope) == property.gapful) {
                        ++i;
                        flag = true;
                    }
                }
                if (spy(num1)) {
                    arr.add("spy");
                    if (property.valueOf(ope) == property.spy) {
                        ++i;
                        flag = true;
                    }
                }
                if (evenOrOdd(num1)) {
                    arr.add("even");
                    if (property.valueOf(ope) == property.even) {
                        ++i;
                        flag = true;
                    }
                } else {
                    arr.add("odd");
                    if (property.valueOf(ope) == property.odd) {
                        ++i;
                        flag = true;
                    }
                }
                if (flag) {
                    System.out.print(num1 + " is ");
                    print(arr);
                }
            }
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

        private static void twoNumber(long num1, long num2) {
            for (int i = 1; i <= num2; i++, ++num1) {
                List<String> arr = new ArrayList<>();
                System.out.print(num1 + " is ");
                if (buzzCheck(num1)) {
                    arr.add("buzz");
                }
                if (duckCheck(num1)) {
                    arr.add("duck");
                }
                if (palindromic(num1)) {
                    arr.add("palindromic");
                }
                if (gapfulNumber(num1)) {
                    arr.add("gapful");
                }
                if (spy(num1)) {
                    arr.add("spy");
                }
                if (evenOrOdd(num1)) {
                    arr.add("even");
                } else {
                    arr.add("odd");
                }
                print(arr);
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

        private static boolean gapfulNumber(long num) {
            String convert = String.valueOf(num);
            int first = convert.charAt(0) - '0';
            int last = convert.charAt(convert.length() - 1) - '0';
            return num % (first * 10 + last) == 0 && convert.length() > 2;
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

        private static boolean spy(long num) {
            long sum = 0;
            long product = 1;
            while (num != 0) {
                sum += num % 10;
                product *= num % 10;
                num /= 10;
            }
            return sum == product;
        }
    }
}
