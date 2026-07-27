import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * currentNumber;
                currentNumber = 0;
                
                result *= stack.pop(); // Multiply by the saved sign before '('
                result += stack.pop(); // Add the saved result before '('
            }
        }

        result += sign * currentNumber;
        return result;
    }
}