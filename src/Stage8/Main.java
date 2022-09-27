package Stage8;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

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
                    continue;
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
                String temp = prop.get(i).toLowerCase().replaceFirst("-", "");
                Operation.property.valueOf(temp);
                prop.remove(i);
                --i;
            } catch (Exception e) {
                prop2.remove(j);
                --j;
            }
        }
        if (prop.size() > 1) {
            System.out.println("The properties ... are wrong\nAvailable properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return true;
        }
        if (prop.size() == 1) {
            System.out.println("The property [" + prop.get(0).toUpperCase() + "] is wrong\nAvailable properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return true;
        }
        return checkMutually(prop2);
    }

    private static boolean checkMut(List<String> list) {
        List<String> l1 = new ArrayList<>(Arrays.asList("even", "odd"));
        List<String> l5 = new ArrayList<>(Arrays.asList("-even", "-odd"));
        List<String> l2 = new ArrayList<>(Arrays.asList("sunny", "square"));
        List<String> l3 = new ArrayList<>(Arrays.asList("duck", "spy"));
        List<String> l4 = new ArrayList<>(Arrays.asList("happy", "sad"));
        List<String> l6 = new ArrayList<>(Arrays.asList("-happy", "-sad"));
        return Objects.equals(list.get(0).replaceFirst("-", ""), list.get(1).replaceFirst("-", ""))
                || new HashSet<>(list).containsAll(l1) || new HashSet<>(list).containsAll(l2)
                || new HashSet<>(list).containsAll(l3) || new HashSet<>(list).containsAll(l4)
                || new HashSet<>(list).containsAll(l5) || new HashSet<>(list).containsAll(l6);
    }

    private static boolean checkMutually(List<String> prop) {
        prop.remove(0);
        prop.remove(0);
        prop = prop.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < prop.size() - 1; i++) {
            String a;
            a = prop.get(i).toLowerCase();
            String b;
            for (int j = i + 1; j < prop.size(); j++) {
                b = prop.get(j).toLowerCase();
                if (checkMut(Arrays.asList(a, b))) {
                    System.out.println("The request contains mutually exclusive properties: [" + prop.get(i).toUpperCase() + ", "
                            + prop.get(j).toUpperCase() + "]\n" + "There are no numbers with these properties.");
                    return true;
                }
            }
        }
        return false;
    }
}