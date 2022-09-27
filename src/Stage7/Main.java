package Stage7;

import java.util.*;
import java.util.regex.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final Pattern pattern = Pattern.compile("[a-zA-Z]|-");

    public static void main(String[] args) {
        new Operation();
        while (true) {
            System.out.println("Enter a request:");
            String[] input = scanner.nextLine().toLowerCase(Locale.ROOT).split(" ");

            if (input.length == 1) {
                if (check(input[0])) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if ("0".equalsIgnoreCase(input[0])) {
                    System.out.println("Goodbye!");
                    return;
                }
                new Operation(1, input);
            } else {// length > 1
                if (twoCheck(input) || checkProperties(input)) {
                    continue;
                }
                new Operation(input.length, input);
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

    private static boolean checkProperties(String[] properties) {
        List<String> prop = new ArrayList<>(List.of(properties));
        List<String> prop2 = new ArrayList<>(List.of(properties));
        prop.remove(0);
        prop.remove(0);
        for (int i = 0, j = 0; i < prop.size(); ++j, ++i) {
            try {
                Operation.property.valueOf(prop.get(i).toLowerCase(Locale.ROOT));
                prop.remove(i);
                --i;
            } catch (Exception e) {
                prop2.remove(j);
                --j;
            }
        }
        if (prop.size() > 1) {
            System.out.println("The properties ... are wrong\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, " +
                    "PALINDROMIC, GAPFUL, SPY, SQUARE, JUMPING, SUNNY]");
            return true;
        }
        if (prop.size() == 1) {
            System.out.println("The property [" + prop.get(0).toUpperCase() + "] is wrong\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, " +
                    "PALINDROMIC, GAPFUL, SPY, SQUARE, JUMPING, SUNNY]");
            return true;
        }
        return checkMutually(prop2);
    }

    private static boolean checkMutually(List<String> prop) {
        List<String> l1 = new ArrayList<>(Arrays.asList("even", "odd"));
        List<String> l2 = new ArrayList<>(Arrays.asList("sunny", "square"));
        List<String> l3 = new ArrayList<>(Arrays.asList("duck", "spy"));
        if (new HashSet<>(prop).containsAll(l1)) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (new HashSet<>(prop).containsAll(l2)) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (new HashSet<>(prop).containsAll(l3)) {
            System.out.println("The request contains mutually exclusive properties: [DUCK,SPY]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        return false;
    }
}