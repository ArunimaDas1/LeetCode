public class Solution {
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }
}

public class Solution {
    public static String reverseString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}


public class Solution {
    public static boolean isPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }

    private static boolean helper(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return helper(s, left + 1, right - 1);
    }
}