import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        Deque<Double> stack = new ArrayDeque<>();
        
        for (double[] car : cars) {
            double time = car[1];
            stack.push(time);
            
            if (stack.size() >= 2) {
                double current = stack.pop();
                double ahead = stack.peek();
                
                if (current > ahead) {
                    stack.push(current);
                }
            }
        }
        
        return stack.size();
    }
}