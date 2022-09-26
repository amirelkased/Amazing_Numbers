package Stage6;

public class Property {
    static boolean evenOrOdd(long num) {
        return num % 2 == 0;
    }

    static boolean buzzCheck(long num) {
        return num % 10 == 7 || num % 7 == 0;
    }

    static boolean duckCheck(long num) {
        return String.valueOf(num).contains("0");
    }

    static boolean gapfulNumber(long num) {
        String convert = String.valueOf(num);
        int first = convert.charAt(0) - '0';
        int last = convert.charAt(convert.length() - 1) - '0';
        return num % (first * 10 + last) == 0 && convert.length() > 2;
    }

    static boolean palindromic(long num) {
        String number = String.valueOf(num);
        for (int i = 0, j = number.length() - 1; i <= j; i++, --j) {
            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static boolean spy(long num) {
        long sum = 0;
        long product = 1;
        while (num != 0) {
            sum += num % 10;
            product *= num % 10;
            num /= 10;
        }
        return sum == product;
    }

    static boolean square(long num) {
        double sq = Math.sqrt(num);
        return sq == (int) sq;
    }

    static boolean sunny(long num) {
        return square(num + 1);
    }
}
