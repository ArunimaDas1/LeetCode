import java.util.*;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, "o", sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, String dir, StringBuilder sb) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir);
        dfs(grid, i + 1, j, "u", sb);
        dfs(grid, i - 1, j, "d", sb);
        dfs(grid, i, j + 1, "r", sb);
        dfs(grid, i, j - 1, "l", sb);
        sb.append("b");
    }
}