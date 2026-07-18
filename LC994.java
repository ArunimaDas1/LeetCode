class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int row = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cell = queue.remove();
                for (int[] dir : dirs) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];
                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}