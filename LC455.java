import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex = 0;
        int cookieIndex = 0;
        
        // Greedy choice: Give the smallest possible cookie that satisfies the least greedy child
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                // Child is satisfied, move to the next child
                childIndex++;
            }
            // Move to the next cookie regardless
            cookieIndex++;
        }
        
        return childIndex;
    }
}