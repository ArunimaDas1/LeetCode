class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                col[i] = 0;

                while (!queue.isEmpty()) {
                    int curr = queue.remove();
                    for (int neighbor : graph[curr]) {
                        if (col[neighbor] == -1) {
                            col[neighbor] = col[curr] == 0 ? 1 : 0;
                            queue.add(neighbor);
                        } else if (col[neighbor] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}