import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && rooms[nr][nc] == Integer.MAX_VALUE) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}