class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int r = cell[0], c = cell[1], dist = cell[2];
            result[r][c] = dist;

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC, dist + 1});
                }
            }
        }

        return result;
    }
}