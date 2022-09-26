package Stage6;


import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final Pattern pattern = Pattern.compile("[a-zA-Z]|-");

    public static void main(String[] args) {
        new Operation();
        while (true) {
            System.out.println("Enter a request:");
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 1) {
                if (check(input[0])) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if ("0".equalsIgnoreCase(input[0])) {
                    System.out.println("Goodbye!");
                    return;
                }
                new Operation(1, input);
            } else if (input.length == 2) {
                if (!twoCheck(input)) {
                    new Operation(2, input);
                }
            } else if (input.length == 3) { // length == 3
                if (twoCheck(input) || checkProperty(input[2])) {
                    continue;
                }
                new Operation(3, input);
            } else {// length == 4
                if (twoCheck(input) || checkTwoProperty(input[2], input[3]) || checkMutually(input[2], input[3])) {
                    continue;
                }
                new Operation(4, input);
            }
        }
    }


    private static boolean twoCheck(String[] input) {
        if (check(input[0])) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if (check(input[1])) {
            System.out.println("The second parameter should be a natural number.");
            return true;
        }
        return false;
    }

    private static boolean check(String input) {
        return pattern.matcher(input).find();
    }

    private static boolean checkProperty(String property) {
        try {
            Operation.property.valueOf(property.toLowerCase(Locale.ROOT));
            return false;
        } catch (Exception e) {
            System.out.println("The property [" + property.toUpperCase(Locale.ROOT)
                    + "] is wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, " +
                    "PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
    }

    private static boolean checkTwoProperty(String property1, String property2) {
        try {
            Operation.property.valueOf(property1.toLowerCase(Locale.ROOT));
            property1 = null;
        } catch (Exception ignored) {
        }
        try {
            Operation.property.valueOf(property2.toLowerCase(Locale.ROOT));
            property2 = null;
        } catch (Exception ignored) {
        }
        if (property1 != null || property2 != null) {
            if (property1 != null && property2 != null) {
                System.out.println("The properties ... are wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, " +
                        "PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            } else if (property1 != null) {
                System.out.println("The property [" + property1.toUpperCase(Locale.ROOT)
                        + "] is wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, " +
                        "PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            } else {
                System.out.println("The property [" + property2.toUpperCase(Locale.ROOT)
                        + "] is wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, " +
                        "PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            }
            return true;
        }
        return false;
    }

    private static boolean checkMutually(String a, String b) {
        switch (a.toLowerCase()) {
            case "even", "odd" -> {
                if (!"odd".equalsIgnoreCase(b) && !"even".equalsIgnoreCase(b)) {
                    return false;
                }
            }
            case "duck", "spy" -> {
                if (!"duck".equalsIgnoreCase(b) && !"spy".equalsIgnoreCase(b)) {
                    return false;
                }
            }
            case "sunny", "square" -> {
                if (!"sunny".equalsIgnoreCase(b) && !"square".equalsIgnoreCase(b)) {
                    return false;
                }
            }
            default -> {
                return false;
            }
        }
        System.out.println("The request contains mutually exclusive properties: ["
                + a.toUpperCase() + ", " + b.toUpperCase() + "]\nThere are no numbers with these properties.");
        return true;
    }

}
