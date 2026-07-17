class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1; // Start at top-right corner

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] > target) {
                col--; // Current value too big -> move left to smaller values
            } else {
                row++; // Current value too small -> move down to larger values
            }
        }

        return false; // Bounds exhausted, target not present
    }
}