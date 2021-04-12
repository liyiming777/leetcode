package com.lym.package01;

public class Jianzhi12 {
    //剑指 Offer 12. 矩阵中的路径
    public boolean exist(char[][] board, String word) {
        int len = board.length;
        int row = board[0].length;
        boolean[][] exist = new boolean[len][row];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < row; j++) {
                if (dfs(0, 0, 0, word, board, exist))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int cur, String target, char[][] board, boolean[][] exist) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || target.charAt(cur) != board[i][j] || exist[i][j])
            return false;
        if (cur == target.length() - 1)
            return true;
        exist[i][j] = true;
        boolean flag = dfs(i + 1, j, cur + 1, target, board, exist) || dfs(i, j + 1, cur + 1, target, board, exist) ||
                dfs(i - 1, j, cur + 1, target, board, exist) || dfs(i, j - 1, cur + 1, target, board, exist);
        exist[i][j] = false;
        return flag;
    }
}
