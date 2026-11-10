import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    private Queue<Integer> queue;
    private int windowSize;
    private double windowSum;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.windowSize = size;
        this.windowSum = 0;
    }
    
    public double next(int val) {
        // If window is full, remove the oldest element from the sum and queue
        if (queue.size() == windowSize) {
            windowSum -= queue.poll();
        }
        
        // Add the new value
        queue.offer(val);
        windowSum += val;
        
        // Return the current moving average
        return windowSum / queue.size();
    }
}public class LC346 {

}
