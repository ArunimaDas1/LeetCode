import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            // Collision condition: Stack has a moving-right (positive) and current is moving-left (negative)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();

                if (top < Math.abs(ast)) {
                    stack.pop(); // Top asteroid explodes, keep checking stack
                    continue; 
                } else if (top == Math.abs(ast)) {
                    stack.pop(); // Both explode
                }
                
                destroyed = true; // Current asteroid is destroyed
                break;
            }

            // If the current asteroid survived all collisions, push it to stack
            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack back to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}