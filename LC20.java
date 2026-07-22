import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If stack is empty or the closing bracket doesn't match top
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // Return true only if all open brackets were matched and popped
        return stack.isEmpty();
    }
}