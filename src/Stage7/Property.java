package Stage7;

public class Property {
    static boolean isEvenOrOdd(long num) {
        return num % 2 == 0;
    }

    static boolean isBuzz(long num) {
        return num % 10 == 7 || num % 7 == 0;
    }

    static boolean isDuck(long num) {
        return String.valueOf(num).contains("0");
    }

    static boolean isGapful(long num) {
        String convert = String.valueOf(num);
        int first = convert.charAt(0) - '0';
        int last = convert.charAt(convert.length() - 1) - '0';
        return num % (first * 10 + last) == 0 && convert.length() > 2;
    }

    static boolean isPalindromic(long num) {
        String number = String.valueOf(num);
        for (int i = 0, j = number.length() - 1; i <= j; i++, --j) {
            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static boolean isSpy(long num) {
        long sum = 0;
        long product = 1;
        while (num != 0) {
            sum += num % 10;
            product *= num % 10;
            num /= 10;
        }
        return sum == product;
    }

    static boolean isSquare(long num) {
        double sq = Math.sqrt(num);
        return sq == (int) sq;
    }

    static boolean sunny(long num) {
        return isSquare(num + 1);
    }

    static boolean isJumping(long num) {
        String number = String.valueOf(num);
        for (int i = 1; i < number.length(); i++) {
            if (Math.abs(number.charAt(i) - number.charAt(i - 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
