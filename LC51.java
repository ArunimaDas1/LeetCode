import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, List<List<String>> result) {
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (char[] r : board) {
                current.add(new String(r));
            }
            result.add(current);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2 = row + col;

            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }
}