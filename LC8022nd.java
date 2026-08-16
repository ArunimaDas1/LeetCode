import java.util.*;

class Solution {
    private int[][] graph;
    private int[] state; // 0 = unvisited, 1 = visiting, 2 = safe, 3 = unsafe

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        state = new int[n];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int node) {
        if (state[node] == 1) return false;
        if (state[node] == 2) return true;
        if (state[node] == 3) return false;

        state[node] = 1;
        for (int neighbor : graph[node]) {
            if (!dfs(neighbor)) {
                state[node] = 3;
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}