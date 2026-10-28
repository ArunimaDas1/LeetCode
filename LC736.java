import java.util.*;

class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String e, Map<String, Integer> prevScope) {
        // 1. If it's an integer, parse and return it
        if (Character.isDigit(e.charAt(0)) || e.charAt(0) == '-') {
            return Integer.parseInt(e);
        }
        
        // 2. If it's a variable, look up its value in the current scope
        if (prevScope.containsKey(e)) {
            return prevScope.get(e);
        }

        // Create a new scope extending the previous scope
        Map<String, Integer> scope = new HashMap<>(prevScope);

        // Strip outer parentheses: e.g., "(add 1 2)" -> "add 1 2"
        int spaceIndex = e.indexOf(' ');
        String nextExpression = e.substring(spaceIndex + 1, e.length() - 1);
        List<String> tokens = split(nextExpression);

        // 3. Handle 'mult'
        if (e.startsWith("(m")) {
            return evaluate(tokens.get(0), scope) * evaluate(tokens.get(1), scope);
        } 
        // 4. Handle 'add'
        else if (e.startsWith("(a")) {
            return evaluate(tokens.get(0), scope) + evaluate(tokens.get(1), scope);
        } 
        // 5. Handle 'let'
        else {
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                scope.put(tokens.get(i), evaluate(tokens.get(i + 1), scope));
            }
            return evaluate(tokens.get(tokens.size() - 1), scope);
        }
    }

    // Helper to split space-separated tokens while respecting nested parentheses
    private List<String> split(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') opened++;
            else if (c == ')') opened--;
            
            if (opened == 0 && c == ' ') {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }
        return tokens;
    }
}